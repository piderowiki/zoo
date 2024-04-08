package com.ynu.zoo;

import com.ynu.zoo.VO.NettyMessagePOJO;
import com.ynu.zoo.handler.GameHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("ZooServer")
@Slf4j
public class ZooServer implements Runnable {
    private int port = 9999;
    @Autowired
    private GameHandler gameHandler;


    @Override
    public void run() {
        // 创建两个线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();// 有8个子线程

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 获取到pipeline
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder",new ProtobufDecoder(
                                    NettyMessagePOJO.NettyMessage.getDefaultInstance()
                            ));
                            pipeline.addLast("encoder",new ProtobufEncoder());
                            // 加入自己的Handler
                            pipeline.addLast(gameHandler);
                        }
                    });
            System.out.println("netty服务器开始启动...");
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            // 监听关闭
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            log.error("netty连接出现了问题");
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
