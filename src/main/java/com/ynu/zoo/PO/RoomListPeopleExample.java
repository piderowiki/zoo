package com.ynu.zoo.PO;

import java.util.ArrayList;
import java.util.List;

public class RoomListPeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomListPeopleExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxIsNull() {
            addCriterion("people_max is null");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxIsNotNull() {
            addCriterion("people_max is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxEqualTo(Integer value) {
            addCriterion("people_max =", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxNotEqualTo(Integer value) {
            addCriterion("people_max <>", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxGreaterThan(Integer value) {
            addCriterion("people_max >", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_max >=", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxLessThan(Integer value) {
            addCriterion("people_max <", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxLessThanOrEqualTo(Integer value) {
            addCriterion("people_max <=", value, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxIn(List<Integer> values) {
            addCriterion("people_max in", values, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxNotIn(List<Integer> values) {
            addCriterion("people_max not in", values, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxBetween(Integer value1, Integer value2) {
            addCriterion("people_max between", value1, value2, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andPeopleMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("people_max not between", value1, value2, "peopleMax");
            return (Criteria) this;
        }

        public Criteria andSpareIsNull() {
            addCriterion("spare is null");
            return (Criteria) this;
        }

        public Criteria andSpareIsNotNull() {
            addCriterion("spare is not null");
            return (Criteria) this;
        }

        public Criteria andSpareEqualTo(String value) {
            addCriterion("spare =", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotEqualTo(String value) {
            addCriterion("spare <>", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThan(String value) {
            addCriterion("spare >", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThanOrEqualTo(String value) {
            addCriterion("spare >=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThan(String value) {
            addCriterion("spare <", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThanOrEqualTo(String value) {
            addCriterion("spare <=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLike(String value) {
            addCriterion("spare like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotLike(String value) {
            addCriterion("spare not like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareIn(List<String> values) {
            addCriterion("spare in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotIn(List<String> values) {
            addCriterion("spare not in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareBetween(String value1, String value2) {
            addCriterion("spare between", value1, value2, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotBetween(String value1, String value2) {
            addCriterion("spare not between", value1, value2, "spare");
            return (Criteria) this;
        }

        public Criteria andPlayer1IsNull() {
            addCriterion("player1 is null");
            return (Criteria) this;
        }

        public Criteria andPlayer1IsNotNull() {
            addCriterion("player1 is not null");
            return (Criteria) this;
        }

        public Criteria andPlayer1EqualTo(String value) {
            addCriterion("player1 =", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1NotEqualTo(String value) {
            addCriterion("player1 <>", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1GreaterThan(String value) {
            addCriterion("player1 >", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1GreaterThanOrEqualTo(String value) {
            addCriterion("player1 >=", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1LessThan(String value) {
            addCriterion("player1 <", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1LessThanOrEqualTo(String value) {
            addCriterion("player1 <=", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1Like(String value) {
            addCriterion("player1 like", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1NotLike(String value) {
            addCriterion("player1 not like", value, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1In(List<String> values) {
            addCriterion("player1 in", values, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1NotIn(List<String> values) {
            addCriterion("player1 not in", values, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1Between(String value1, String value2) {
            addCriterion("player1 between", value1, value2, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer1NotBetween(String value1, String value2) {
            addCriterion("player1 not between", value1, value2, "player1");
            return (Criteria) this;
        }

        public Criteria andPlayer2IsNull() {
            addCriterion("player2 is null");
            return (Criteria) this;
        }

        public Criteria andPlayer2IsNotNull() {
            addCriterion("player2 is not null");
            return (Criteria) this;
        }

        public Criteria andPlayer2EqualTo(String value) {
            addCriterion("player2 =", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2NotEqualTo(String value) {
            addCriterion("player2 <>", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2GreaterThan(String value) {
            addCriterion("player2 >", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2GreaterThanOrEqualTo(String value) {
            addCriterion("player2 >=", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2LessThan(String value) {
            addCriterion("player2 <", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2LessThanOrEqualTo(String value) {
            addCriterion("player2 <=", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2Like(String value) {
            addCriterion("player2 like", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2NotLike(String value) {
            addCriterion("player2 not like", value, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2In(List<String> values) {
            addCriterion("player2 in", values, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2NotIn(List<String> values) {
            addCriterion("player2 not in", values, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2Between(String value1, String value2) {
            addCriterion("player2 between", value1, value2, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer2NotBetween(String value1, String value2) {
            addCriterion("player2 not between", value1, value2, "player2");
            return (Criteria) this;
        }

        public Criteria andPlayer3IsNull() {
            addCriterion("player3 is null");
            return (Criteria) this;
        }

        public Criteria andPlayer3IsNotNull() {
            addCriterion("player3 is not null");
            return (Criteria) this;
        }

        public Criteria andPlayer3EqualTo(String value) {
            addCriterion("player3 =", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3NotEqualTo(String value) {
            addCriterion("player3 <>", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3GreaterThan(String value) {
            addCriterion("player3 >", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3GreaterThanOrEqualTo(String value) {
            addCriterion("player3 >=", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3LessThan(String value) {
            addCriterion("player3 <", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3LessThanOrEqualTo(String value) {
            addCriterion("player3 <=", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3Like(String value) {
            addCriterion("player3 like", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3NotLike(String value) {
            addCriterion("player3 not like", value, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3In(List<String> values) {
            addCriterion("player3 in", values, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3NotIn(List<String> values) {
            addCriterion("player3 not in", values, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3Between(String value1, String value2) {
            addCriterion("player3 between", value1, value2, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer3NotBetween(String value1, String value2) {
            addCriterion("player3 not between", value1, value2, "player3");
            return (Criteria) this;
        }

        public Criteria andPlayer4IsNull() {
            addCriterion("player4 is null");
            return (Criteria) this;
        }

        public Criteria andPlayer4IsNotNull() {
            addCriterion("player4 is not null");
            return (Criteria) this;
        }

        public Criteria andPlayer4EqualTo(String value) {
            addCriterion("player4 =", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4NotEqualTo(String value) {
            addCriterion("player4 <>", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4GreaterThan(String value) {
            addCriterion("player4 >", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4GreaterThanOrEqualTo(String value) {
            addCriterion("player4 >=", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4LessThan(String value) {
            addCriterion("player4 <", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4LessThanOrEqualTo(String value) {
            addCriterion("player4 <=", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4Like(String value) {
            addCriterion("player4 like", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4NotLike(String value) {
            addCriterion("player4 not like", value, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4In(List<String> values) {
            addCriterion("player4 in", values, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4NotIn(List<String> values) {
            addCriterion("player4 not in", values, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4Between(String value1, String value2) {
            addCriterion("player4 between", value1, value2, "player4");
            return (Criteria) this;
        }

        public Criteria andPlayer4NotBetween(String value1, String value2) {
            addCriterion("player4 not between", value1, value2, "player4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}