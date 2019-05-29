package cc.xuepeng.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuCondition implements Serializable {

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
    public MenuCondition() {
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
        private static final String PID = "pid";

        public Criteria andPidIsNull() {
            addCriterion("`pid` is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("`pid` is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("`pid` =", value, PID);
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("`pid` <>", value, PID);
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("`pid` >", value, PID);
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("`pid` >=", value, PID);
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("`pid` <", value, PID);
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("`pid` <=", value, PID);
            return (Criteria) this;
        }

        private static final String PID_LIKE = "`pid` like";
        private static final String PID_NOT_LIKE = "`pid` not like";

        public Criteria andPidLike(String value) {
            addCriterion(PID_LIKE, value, PID);
            return (Criteria) this;
        }

        public Criteria andPidLikeOnLeft(String value) {
            addCriterion(PID_LIKE, "%" + value, PID);
            return (Criteria) this;
        }

        public Criteria andPidLikeOnRight(String value) {
            addCriterion(PID_LIKE, value + "%", PID);
            return (Criteria) this;
        }

        public Criteria andPidLikeOnBoth(String value) {
            addCriterion(PID_LIKE, "%" + value + "%", PID);
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion(PID_NOT_LIKE, value, PID);
            return (Criteria) this;
        }

        public Criteria andPidNotLikeOnLeft(String value) {
            addCriterion(PID_NOT_LIKE, "%" + value, PID);
            return (Criteria) this;
        }

        public Criteria andPidNotLikeOnRight(String value) {
            addCriterion(PID_NOT_LIKE, value + "%", PID);
            return (Criteria) this;
        }

        public Criteria andPidNotLikeOnBoth(String value) {
            addCriterion(PID_NOT_LIKE, "%" + value + "%", PID);
            return (Criteria) this;
        }
        public Criteria andPidIn(List<String> values) {
            addCriterion("`pid` in", values, PID);
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("`pid` not in", values, PID);
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("`pid` between", value1, value2, PID);
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("`pid` not between", value1, value2, PID);
            return (Criteria) this;
        }
        private static final String TITLE = "title";

        public Criteria andTitleIsNull() {
            addCriterion("`title` is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("`title` is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("`title` =", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("`title` <>", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("`title` >", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`title` >=", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("`title` <", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("`title` <=", value, TITLE);
            return (Criteria) this;
        }

        private static final String TITLE_LIKE = "`title` like";
        private static final String TITLE_NOT_LIKE = "`title` not like";

        public Criteria andTitleLike(String value) {
            addCriterion(TITLE_LIKE, value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLikeOnLeft(String value) {
            addCriterion(TITLE_LIKE, "%" + value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLikeOnRight(String value) {
            addCriterion(TITLE_LIKE, value + "%", TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLikeOnBoth(String value) {
            addCriterion(TITLE_LIKE, "%" + value + "%", TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion(TITLE_NOT_LIKE, value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotLikeOnLeft(String value) {
            addCriterion(TITLE_NOT_LIKE, "%" + value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotLikeOnRight(String value) {
            addCriterion(TITLE_NOT_LIKE, value + "%", TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotLikeOnBoth(String value) {
            addCriterion(TITLE_NOT_LIKE, "%" + value + "%", TITLE);
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("`title` in", values, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("`title` not in", values, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("`title` between", value1, value2, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("`title` not between", value1, value2, TITLE);
            return (Criteria) this;
        }
        private static final String ICON = "icon";

        public Criteria andIconIsNull() {
            addCriterion("`icon` is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("`icon` is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("`icon` =", value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("`icon` <>", value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("`icon` >", value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("`icon` >=", value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("`icon` <", value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("`icon` <=", value, ICON);
            return (Criteria) this;
        }

        private static final String ICON_LIKE = "`icon` like";
        private static final String ICON_NOT_LIKE = "`icon` not like";

        public Criteria andIconLike(String value) {
            addCriterion(ICON_LIKE, value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconLikeOnLeft(String value) {
            addCriterion(ICON_LIKE, "%" + value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconLikeOnRight(String value) {
            addCriterion(ICON_LIKE, value + "%", ICON);
            return (Criteria) this;
        }

        public Criteria andIconLikeOnBoth(String value) {
            addCriterion(ICON_LIKE, "%" + value + "%", ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion(ICON_NOT_LIKE, value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotLikeOnLeft(String value) {
            addCriterion(ICON_NOT_LIKE, "%" + value, ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotLikeOnRight(String value) {
            addCriterion(ICON_NOT_LIKE, value + "%", ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotLikeOnBoth(String value) {
            addCriterion(ICON_NOT_LIKE, "%" + value + "%", ICON);
            return (Criteria) this;
        }
        public Criteria andIconIn(List<String> values) {
            addCriterion("`icon` in", values, ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("`icon` not in", values, ICON);
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("`icon` between", value1, value2, ICON);
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("`icon` not between", value1, value2, ICON);
            return (Criteria) this;
        }
        private static final String PATH = "path";

        public Criteria andPathIsNull() {
            addCriterion("`path` is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("`path` is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("`path` =", value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("`path` <>", value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("`path` >", value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("`path` >=", value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("`path` <", value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("`path` <=", value, PATH);
            return (Criteria) this;
        }

        private static final String PATH_LIKE = "`path` like";
        private static final String PATH_NOT_LIKE = "`path` not like";

        public Criteria andPathLike(String value) {
            addCriterion(PATH_LIKE, value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathLikeOnLeft(String value) {
            addCriterion(PATH_LIKE, "%" + value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathLikeOnRight(String value) {
            addCriterion(PATH_LIKE, value + "%", PATH);
            return (Criteria) this;
        }

        public Criteria andPathLikeOnBoth(String value) {
            addCriterion(PATH_LIKE, "%" + value + "%", PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion(PATH_NOT_LIKE, value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotLikeOnLeft(String value) {
            addCriterion(PATH_NOT_LIKE, "%" + value, PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotLikeOnRight(String value) {
            addCriterion(PATH_NOT_LIKE, value + "%", PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotLikeOnBoth(String value) {
            addCriterion(PATH_NOT_LIKE, "%" + value + "%", PATH);
            return (Criteria) this;
        }
        public Criteria andPathIn(List<String> values) {
            addCriterion("`path` in", values, PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("`path` not in", values, PATH);
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("`path` between", value1, value2, PATH);
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("`path` not between", value1, value2, PATH);
            return (Criteria) this;
        }
        private static final String SORT = "sort";

        public Criteria andSortIsNull() {
            addCriterion("`sort` is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("`sort` is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Short value) {
            addCriterion("`sort` =", value, SORT);
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("`sort` <>", value, SORT);
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("`sort` >", value, SORT);
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("`sort` >=", value, SORT);
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("`sort` <", value, SORT);
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("`sort` <=", value, SORT);
            return (Criteria) this;
        }
        public Criteria andSortIn(List<Short> values) {
            addCriterion("`sort` in", values, SORT);
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("`sort` not in", values, SORT);
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("`sort` between", value1, value2, SORT);
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("`sort` not between", value1, value2, SORT);
            return (Criteria) this;
        }
        private static final String DELETED = "deleted";

        public Criteria andDeletedIsNull() {
            addCriterion("`deleted` is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("`deleted` is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("`deleted` =", value, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("`deleted` <>", value, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("`deleted` >", value, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`deleted` >=", value, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("`deleted` <", value, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("`deleted` <=", value, DELETED);
            return (Criteria) this;
        }
        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("`deleted` in", values, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("`deleted` not in", values, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("`deleted` between", value1, value2, DELETED);
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`deleted` not between", value1, value2, DELETED);
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

        public Criteria andRemarkEqualTo(Integer value) {
            addCriterion("`remark` =", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(Integer value) {
            addCriterion("`remark` <>", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(Integer value) {
            addCriterion("`remark` >", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("`remark` >=", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(Integer value) {
            addCriterion("`remark` <", value, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(Integer value) {
            addCriterion("`remark` <=", value, REMARK);
            return (Criteria) this;
        }
        public Criteria andRemarkIn(List<Integer> values) {
            addCriterion("`remark` in", values, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<Integer> values) {
            addCriterion("`remark` not in", values, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(Integer value1, Integer value2) {
            addCriterion("`remark` between", value1, value2, REMARK);
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(Integer value1, Integer value2) {
            addCriterion("`remark` not between", value1, value2, REMARK);
            return (Criteria) this;
        }
        private static final String CREATEUSER = "createUser";

        public Criteria andCreateUserIsNull() {
            addCriterion("`create_user` is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("`create_user` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("`create_user` =", value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("`create_user` <>", value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("`create_user` >", value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("`create_user` >=", value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("`create_user` <", value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("`create_user` <=", value, CREATEUSER);
            return (Criteria) this;
        }

        private static final String CREATEUSER_LIKE = "`create_user` like";
        private static final String CREATEUSER_NOT_LIKE = "`create_user` not like";

        public Criteria andCreateUserLike(String value) {
            addCriterion(CREATEUSER_LIKE, value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeOnLeft(String value) {
            addCriterion(CREATEUSER_LIKE, "%" + value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeOnRight(String value) {
            addCriterion(CREATEUSER_LIKE, value + "%", CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeOnBoth(String value) {
            addCriterion(CREATEUSER_LIKE, "%" + value + "%", CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion(CREATEUSER_NOT_LIKE, value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLikeOnLeft(String value) {
            addCriterion(CREATEUSER_NOT_LIKE, "%" + value, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLikeOnRight(String value) {
            addCriterion(CREATEUSER_NOT_LIKE, value + "%", CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLikeOnBoth(String value) {
            addCriterion(CREATEUSER_NOT_LIKE, "%" + value + "%", CREATEUSER);
            return (Criteria) this;
        }
        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("`create_user` in", values, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("`create_user` not in", values, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("`create_user` between", value1, value2, CREATEUSER);
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("`create_user` not between", value1, value2, CREATEUSER);
            return (Criteria) this;
        }
        private static final String MODIFYUSER = "modifyUser";

        public Criteria andModifyUserIsNull() {
            addCriterion("`modify_user` is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("`modify_user` is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("`modify_user` =", value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("`modify_user` <>", value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("`modify_user` >", value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("`modify_user` >=", value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("`modify_user` <", value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("`modify_user` <=", value, MODIFYUSER);
            return (Criteria) this;
        }

        private static final String MODIFYUSER_LIKE = "`modify_user` like";
        private static final String MODIFYUSER_NOT_LIKE = "`modify_user` not like";

        public Criteria andModifyUserLike(String value) {
            addCriterion(MODIFYUSER_LIKE, value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserLikeOnLeft(String value) {
            addCriterion(MODIFYUSER_LIKE, "%" + value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserLikeOnRight(String value) {
            addCriterion(MODIFYUSER_LIKE, value + "%", MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserLikeOnBoth(String value) {
            addCriterion(MODIFYUSER_LIKE, "%" + value + "%", MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion(MODIFYUSER_NOT_LIKE, value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLikeOnLeft(String value) {
            addCriterion(MODIFYUSER_NOT_LIKE, "%" + value, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLikeOnRight(String value) {
            addCriterion(MODIFYUSER_NOT_LIKE, value + "%", MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLikeOnBoth(String value) {
            addCriterion(MODIFYUSER_NOT_LIKE, "%" + value + "%", MODIFYUSER);
            return (Criteria) this;
        }
        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("`modify_user` in", values, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("`modify_user` not in", values, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("`modify_user` between", value1, value2, MODIFYUSER);
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("`modify_user` not between", value1, value2, MODIFYUSER);
            return (Criteria) this;
        }
        private static final String CREATETIME = "createTime";

        public Criteria andCreateTimeIsNull() {
            addCriterion("`create_time` is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("`create_time` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("`create_time` =", value, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("`create_time` <>", value, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("`create_time` >", value, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`create_time` >=", value, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("`create_time` <", value, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("`create_time` <=", value, CREATETIME);
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("`create_time` in", values, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("`create_time` not in", values, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("`create_time` between", value1, value2, CREATETIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("`create_time` not between", value1, value2, CREATETIME);
            return (Criteria) this;
        }
        private static final String MODIFYTIME = "modifyTime";

        public Criteria andModifyTimeIsNull() {
            addCriterion("`modify_time` is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("`modify_time` is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("`modify_time` =", value, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("`modify_time` <>", value, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("`modify_time` >", value, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`modify_time` >=", value, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("`modify_time` <", value, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("`modify_time` <=", value, MODIFYTIME);
            return (Criteria) this;
        }
        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("`modify_time` in", values, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("`modify_time` not in", values, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("`modify_time` between", value1, value2, MODIFYTIME);
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("`modify_time` not between", value1, value2, MODIFYTIME);
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