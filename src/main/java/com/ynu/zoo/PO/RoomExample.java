package com.ynu.zoo.PO;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleIsNull() {
            addCriterion("online_people is null");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleIsNotNull() {
            addCriterion("online_people is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleEqualTo(String value) {
            addCriterion("online_people =", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleNotEqualTo(String value) {
            addCriterion("online_people <>", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleGreaterThan(String value) {
            addCriterion("online_people >", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("online_people >=", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleLessThan(String value) {
            addCriterion("online_people <", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleLessThanOrEqualTo(String value) {
            addCriterion("online_people <=", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleLike(String value) {
            addCriterion("online_people like", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleNotLike(String value) {
            addCriterion("online_people not like", value, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleIn(List<String> values) {
            addCriterion("online_people in", values, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleNotIn(List<String> values) {
            addCriterion("online_people not in", values, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleBetween(String value1, String value2) {
            addCriterion("online_people between", value1, value2, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andOnlinePeopleNotBetween(String value1, String value2) {
            addCriterion("online_people not between", value1, value2, "onlinePeople");
            return (Criteria) this;
        }

        public Criteria andIsBeginIsNull() {
            addCriterion("is_begin is null");
            return (Criteria) this;
        }

        public Criteria andIsBeginIsNotNull() {
            addCriterion("is_begin is not null");
            return (Criteria) this;
        }

        public Criteria andIsBeginEqualTo(String value) {
            addCriterion("is_begin =", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotEqualTo(String value) {
            addCriterion("is_begin <>", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginGreaterThan(String value) {
            addCriterion("is_begin >", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginGreaterThanOrEqualTo(String value) {
            addCriterion("is_begin >=", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginLessThan(String value) {
            addCriterion("is_begin <", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginLessThanOrEqualTo(String value) {
            addCriterion("is_begin <=", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginLike(String value) {
            addCriterion("is_begin like", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotLike(String value) {
            addCriterion("is_begin not like", value, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginIn(List<String> values) {
            addCriterion("is_begin in", values, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotIn(List<String> values) {
            addCriterion("is_begin not in", values, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginBetween(String value1, String value2) {
            addCriterion("is_begin between", value1, value2, "isBegin");
            return (Criteria) this;
        }

        public Criteria andIsBeginNotBetween(String value1, String value2) {
            addCriterion("is_begin not between", value1, value2, "isBegin");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleIsNull() {
            addCriterion("ready_people is null");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleIsNotNull() {
            addCriterion("ready_people is not null");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleEqualTo(String value) {
            addCriterion("ready_people =", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleNotEqualTo(String value) {
            addCriterion("ready_people <>", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleGreaterThan(String value) {
            addCriterion("ready_people >", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("ready_people >=", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleLessThan(String value) {
            addCriterion("ready_people <", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleLessThanOrEqualTo(String value) {
            addCriterion("ready_people <=", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleLike(String value) {
            addCriterion("ready_people like", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleNotLike(String value) {
            addCriterion("ready_people not like", value, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleIn(List<String> values) {
            addCriterion("ready_people in", values, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleNotIn(List<String> values) {
            addCriterion("ready_people not in", values, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleBetween(String value1, String value2) {
            addCriterion("ready_people between", value1, value2, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andReadyPeopleNotBetween(String value1, String value2) {
            addCriterion("ready_people not between", value1, value2, "readyPeople");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdIsNull() {
            addCriterion("Personnel_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdIsNotNull() {
            addCriterion("Personnel_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdEqualTo(Integer value) {
            addCriterion("Personnel_id =", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdNotEqualTo(Integer value) {
            addCriterion("Personnel_id <>", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdGreaterThan(Integer value) {
            addCriterion("Personnel_id >", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Personnel_id >=", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdLessThan(Integer value) {
            addCriterion("Personnel_id <", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdLessThanOrEqualTo(Integer value) {
            addCriterion("Personnel_id <=", value, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdIn(List<Integer> values) {
            addCriterion("Personnel_id in", values, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdNotIn(List<Integer> values) {
            addCriterion("Personnel_id not in", values, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdBetween(Integer value1, Integer value2) {
            addCriterion("Personnel_id between", value1, value2, "personnelId");
            return (Criteria) this;
        }

        public Criteria andPersonnelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Personnel_id not between", value1, value2, "personnelId");
            return (Criteria) this;
        }

        public Criteria andFirstIsNull() {
            addCriterion("first is null");
            return (Criteria) this;
        }

        public Criteria andFirstIsNotNull() {
            addCriterion("first is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEqualTo(Integer value) {
            addCriterion("first =", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotEqualTo(Integer value) {
            addCriterion("first <>", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThan(Integer value) {
            addCriterion("first >", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThanOrEqualTo(Integer value) {
            addCriterion("first >=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThan(Integer value) {
            addCriterion("first <", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThanOrEqualTo(Integer value) {
            addCriterion("first <=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstIn(List<Integer> values) {
            addCriterion("first in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotIn(List<Integer> values) {
            addCriterion("first not in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstBetween(Integer value1, Integer value2) {
            addCriterion("first between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotBetween(Integer value1, Integer value2) {
            addCriterion("first not between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
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