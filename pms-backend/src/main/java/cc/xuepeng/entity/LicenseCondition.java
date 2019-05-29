package cc.xuepeng.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LicenseCondition implements Serializable {

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
    public LicenseCondition() {
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
        private static final String COMPANY = "company";

        public Criteria andCompanyIsNull() {
            addCriterion("`company` is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("`company` is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("`company` =", value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("`company` <>", value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("`company` >", value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("`company` >=", value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("`company` <", value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("`company` <=", value, COMPANY);
            return (Criteria) this;
        }

        private static final String COMPANY_LIKE = "`company` like";
        private static final String COMPANY_NOT_LIKE = "`company` not like";

        public Criteria andCompanyLike(String value) {
            addCriterion(COMPANY_LIKE, value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyLikeOnLeft(String value) {
            addCriterion(COMPANY_LIKE, "%" + value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyLikeOnRight(String value) {
            addCriterion(COMPANY_LIKE, value + "%", COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyLikeOnBoth(String value) {
            addCriterion(COMPANY_LIKE, "%" + value + "%", COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion(COMPANY_NOT_LIKE, value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotLikeOnLeft(String value) {
            addCriterion(COMPANY_NOT_LIKE, "%" + value, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotLikeOnRight(String value) {
            addCriterion(COMPANY_NOT_LIKE, value + "%", COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotLikeOnBoth(String value) {
            addCriterion(COMPANY_NOT_LIKE, "%" + value + "%", COMPANY);
            return (Criteria) this;
        }
        public Criteria andCompanyIn(List<String> values) {
            addCriterion("`company` in", values, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("`company` not in", values, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("`company` between", value1, value2, COMPANY);
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("`company` not between", value1, value2, COMPANY);
            return (Criteria) this;
        }
        private static final String EXPIREDATE = "expireDate";

        public Criteria andExpireDateIsNull() {
            addCriterion("`expire_date` is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("`expire_date` is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterion("`expire_date` =", value, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterion("`expire_date` <>", value, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterion("`expire_date` >", value, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("`expire_date` >=", value, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterion("`expire_date` <", value, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("`expire_date` <=", value, EXPIREDATE);
            return (Criteria) this;
        }
        public Criteria andExpireDateIn(List<Date> values) {
            addCriterion("`expire_date` in", values, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterion("`expire_date` not in", values, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterion("`expire_date` between", value1, value2, EXPIREDATE);
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("`expire_date` not between", value1, value2, EXPIREDATE);
            return (Criteria) this;
        }
        private static final String REMARK = "remark";

        public Criteria andRemarkIsNull() {
            addCriterion("`remark` is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("`remark` is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("`remark` =", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("`remark` <>", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("`remark` >", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("`remark` >=", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("`remark` <", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("`remark` <=", value, REMARK);
            return (Criteria) this;
        }

        private static final String REMARK_LIKE = "`remark` like";
        private static final String REMARK_NOT_LIKE = "`remark` not like";

        public Criteria andRemarkLike(String value) {
            addCriterion(REMARK_LIKE, value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLikeOnLeft(String value) {
            addCriterion(REMARK_LIKE, "%" + value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLikeOnRight(String value) {
            addCriterion(REMARK_LIKE, value + "%", REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLikeOnBoth(String value) {
            addCriterion(REMARK_LIKE, "%" + value + "%", REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion(REMARK_NOT_LIKE, value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotLikeOnLeft(String value) {
            addCriterion(REMARK_NOT_LIKE, "%" + value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotLikeOnRight(String value) {
            addCriterion(REMARK_NOT_LIKE, value + "%", REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotLikeOnBoth(String value) {
            addCriterion(REMARK_NOT_LIKE, "%" + value + "%", REMARK);
            return (Criteria) this;
        }
        public Criteria andRemarkIn(List<String> values) {
            addCriterion("`remark` in", values, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("`remark` not in", values, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("`remark` between", value1, value2, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("`remark` not between", value1, value2, REMARK);
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