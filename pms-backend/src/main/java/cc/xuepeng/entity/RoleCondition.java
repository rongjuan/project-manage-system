package cc.xuepeng.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleCondition implements Serializable {

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
    public RoleCondition() {
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
        private static final String LICENSEID = "licenseId";

        public Criteria andLicenseIdIsNull() {
            addCriterion("`license_id` is null");
            return (Criteria) this;
        }

        public Criteria andLicenseIdIsNotNull() {
            addCriterion("`license_id` is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseIdEqualTo(String value) {
            addCriterion("`license_id` =", value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotEqualTo(String value) {
            addCriterion("`license_id` <>", value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdGreaterThan(String value) {
            addCriterion("`license_id` >", value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdGreaterThanOrEqualTo(String value) {
            addCriterion("`license_id` >=", value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdLessThan(String value) {
            addCriterion("`license_id` <", value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdLessThanOrEqualTo(String value) {
            addCriterion("`license_id` <=", value, LICENSEID);
            return (Criteria) this;
        }

        private static final String LICENSEID_LIKE = "`license_id` like";
        private static final String LICENSEID_NOT_LIKE = "`license_id` not like";

        public Criteria andLicenseIdLike(String value) {
            addCriterion(LICENSEID_LIKE, value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdLikeOnLeft(String value) {
            addCriterion(LICENSEID_LIKE, "%" + value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdLikeOnRight(String value) {
            addCriterion(LICENSEID_LIKE, value + "%", LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdLikeOnBoth(String value) {
            addCriterion(LICENSEID_LIKE, "%" + value + "%", LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotLike(String value) {
            addCriterion(LICENSEID_NOT_LIKE, value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotLikeOnLeft(String value) {
            addCriterion(LICENSEID_NOT_LIKE, "%" + value, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotLikeOnRight(String value) {
            addCriterion(LICENSEID_NOT_LIKE, value + "%", LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotLikeOnBoth(String value) {
            addCriterion(LICENSEID_NOT_LIKE, "%" + value + "%", LICENSEID);
            return (Criteria) this;
        }
        public Criteria andLicenseIdIn(List<String> values) {
            addCriterion("`license_id` in", values, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotIn(List<String> values) {
            addCriterion("`license_id` not in", values, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdBetween(String value1, String value2) {
            addCriterion("`license_id` between", value1, value2, LICENSEID);
            return (Criteria) this;
        }

        public Criteria andLicenseIdNotBetween(String value1, String value2) {
            addCriterion("`license_id` not between", value1, value2, LICENSEID);
            return (Criteria) this;
        }
        private static final String NAME = "name";

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, NAME);
            return (Criteria) this;
        }

        private static final String NAME_LIKE = "`name` like";
        private static final String NAME_NOT_LIKE = "`name` not like";

        public Criteria andNameLike(String value) {
            addCriterion(NAME_LIKE, value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameLikeOnLeft(String value) {
            addCriterion(NAME_LIKE, "%" + value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameLikeOnRight(String value) {
            addCriterion(NAME_LIKE, value + "%", NAME);
            return (Criteria) this;
        }

        public Criteria andNameLikeOnBoth(String value) {
            addCriterion(NAME_LIKE, "%" + value + "%", NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion(NAME_NOT_LIKE, value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotLikeOnLeft(String value) {
            addCriterion(NAME_NOT_LIKE, "%" + value, NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotLikeOnRight(String value) {
            addCriterion(NAME_NOT_LIKE, value + "%", NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotLikeOnBoth(String value) {
            addCriterion(NAME_NOT_LIKE, "%" + value + "%", NAME);
            return (Criteria) this;
        }
        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, NAME);
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, NAME);
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, NAME);
            return (Criteria) this;
        }
        private static final String STATUS = "status";

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, STATUS);
            return (Criteria) this;
        }
        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, STATUS);
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, STATUS);
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