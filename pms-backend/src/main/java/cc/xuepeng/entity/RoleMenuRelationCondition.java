package cc.xuepeng.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleMenuRelationCondition implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 排序字段。
     */
    protected String orderBy;
    /**
     * 是否过滤重复。
     */
    protected boolean distinct;
    /**
     * 条件参数。
     */
    private List<Criteria> criterias;

    /**
     * 构造函数。
     */
    public RoleMenuRelationCondition() {
        criterias = new ArrayList<>();
    }

    /**
     * @return 获取排序字段。
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置排序字段。
     *
     * @param orderBy 排序字段。
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return 获取是否去掉重复数据的字段。
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 设置获取是否去掉重复数据的字段。
     *
     * @param distinct 获取是否去掉重复数据的字段。
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @return 获取条件参数。
     */
    public List<Criteria> getCriterias() {
        return criterias;
    }

    /**
     * 设置多个条件参数，以or的形式拼接。
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        criterias.add(criteria);
        return criteria;
    }

    /**
     * 设置多个条件参数，以or的形式拼接。
     *
     * @param criteria 条件参数。
     */
    public void or(Criteria criteria) {
        criterias.add(criteria);
    }

    /**
     * @return 创建一个条件查询。
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (criterias.isEmpty()) {
            criterias.add(criteria);
        }
        return criteria;
    }

    /**
     * @return 创建一个条件参数。
     */
    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    /**
     * 清空条件参数。
     */
    public void clear() {
        criterias.clear();
        orderBy = null;
        distinct = false;
    }

    /**
     * 查询条件生成器。
     */
    protected abstract static class GeneratedCriteria {

        /**
        * 查询条件。
        */
        protected List<Criterion> criteria;

        /**
         * 构造函数。
         */
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        /**
         * @return 查询条件是否合法。
         */
        public boolean isValid() {
            return criteria.isEmpty();
        }

        /**
         * @return 获取全部的查询条件。
         */
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        /**
         * @return 获取查询条件。
         */
        public List<Criterion> getCriteria() {
            return criteria;
        }

        /**
         * 添加查询条件。
         *
         * @param condition 条件语句。
         */
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new IllegalArgumentException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        /**
         * 添加查询条件。
         *
         * @param condition 条件语句。
         * @param value     value。
         * @param property  属性。
         */
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new IllegalArgumentException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        /**
         * 添加查询条件。
         *
         * @param condition 条件语句。
         * @param value1    value1。
         * @param value2    value2。
         * @param property  属性。
         */
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new IllegalArgumentException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        private static final String ID = "id";

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("`id` =", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("`id` <>", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("`id` >", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("`id` >=", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("`id` <", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("`id` <=", value, ID);
            return (Criteria) this;
        }

        private static final String ID_LIKE = "`id` like";
        private static final String ID_NOT_LIKE = "`id` not like";

        public Criteria andIdLike(String value) {
            addCriterion(ID_LIKE, value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLikeOnLeft(String value) {
            addCriterion(ID_LIKE, "%" + value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLikeOnRight(String value) {
            addCriterion(ID_LIKE, value + "%", ID);
            return (Criteria) this;
        }

        public Criteria andIdLikeOnBoth(String value) {
            addCriterion(ID_LIKE, "%" + value + "%", ID);
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion(ID_NOT_LIKE, value, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotLikeOnLeft(String value) {
            addCriterion(ID_NOT_LIKE, "%" + value, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotLikeOnRight(String value) {
            addCriterion(ID_NOT_LIKE, value + "%", ID);
            return (Criteria) this;
        }

        public Criteria andIdNotLikeOnBoth(String value) {
            addCriterion(ID_NOT_LIKE, "%" + value + "%", ID);
            return (Criteria) this;
        }
        public Criteria andIdIn(List<String> values) {
            addCriterion("`id` in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("`id` not in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("`id` between", value1, value2, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("`id` not between", value1, value2, ID);
            return (Criteria) this;
        }
        private static final String ROLEID = "roleId";

        public Criteria andRoleIdIsNull() {
            addCriterion("`role_id` is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("`role_id` is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("`role_id` =", value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("`role_id` <>", value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("`role_id` >", value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("`role_id` >=", value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("`role_id` <", value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("`role_id` <=", value, ROLEID);
            return (Criteria) this;
        }

        private static final String ROLEID_LIKE = "`role_id` like";
        private static final String ROLEID_NOT_LIKE = "`role_id` not like";

        public Criteria andRoleIdLike(String value) {
            addCriterion(ROLEID_LIKE, value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdLikeOnLeft(String value) {
            addCriterion(ROLEID_LIKE, "%" + value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdLikeOnRight(String value) {
            addCriterion(ROLEID_LIKE, value + "%", ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdLikeOnBoth(String value) {
            addCriterion(ROLEID_LIKE, "%" + value + "%", ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion(ROLEID_NOT_LIKE, value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLikeOnLeft(String value) {
            addCriterion(ROLEID_NOT_LIKE, "%" + value, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLikeOnRight(String value) {
            addCriterion(ROLEID_NOT_LIKE, value + "%", ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLikeOnBoth(String value) {
            addCriterion(ROLEID_NOT_LIKE, "%" + value + "%", ROLEID);
            return (Criteria) this;
        }
        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("`role_id` in", values, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("`role_id` not in", values, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("`role_id` between", value1, value2, ROLEID);
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("`role_id` not between", value1, value2, ROLEID);
            return (Criteria) this;
        }
        private static final String MENUID = "menuId";

        public Criteria andMenuIdIsNull() {
            addCriterion("`menu_id` is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("`menu_id` is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("`menu_id` =", value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("`menu_id` <>", value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("`menu_id` >", value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("`menu_id` >=", value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("`menu_id` <", value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("`menu_id` <=", value, MENUID);
            return (Criteria) this;
        }

        private static final String MENUID_LIKE = "`menu_id` like";
        private static final String MENUID_NOT_LIKE = "`menu_id` not like";

        public Criteria andMenuIdLike(String value) {
            addCriterion(MENUID_LIKE, value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdLikeOnLeft(String value) {
            addCriterion(MENUID_LIKE, "%" + value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdLikeOnRight(String value) {
            addCriterion(MENUID_LIKE, value + "%", MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdLikeOnBoth(String value) {
            addCriterion(MENUID_LIKE, "%" + value + "%", MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion(MENUID_NOT_LIKE, value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLikeOnLeft(String value) {
            addCriterion(MENUID_NOT_LIKE, "%" + value, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLikeOnRight(String value) {
            addCriterion(MENUID_NOT_LIKE, value + "%", MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLikeOnBoth(String value) {
            addCriterion(MENUID_NOT_LIKE, "%" + value + "%", MENUID);
            return (Criteria) this;
        }
        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("`menu_id` in", values, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("`menu_id` not in", values, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("`menu_id` between", value1, value2, MENUID);
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("`menu_id` not between", value1, value2, MENUID);
            return (Criteria) this;
        }

    }

    /**
     * 条件参数。
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        /**
         * 构造函数。
         */
        protected Criteria() {
            super();
        }

    }

    /**
     * Mapper中用到的条件参数对象。
     */
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