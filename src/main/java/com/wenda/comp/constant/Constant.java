package com.wenda.comp.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description: 常量类
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class Constant {

	public static final String MESSAGE_SUCCESS = "message_success";// 操作成功标识符

	public static final String MESSAGE_ERROR = "message_error";// 操作错误标识符

	public static final String MESSAGE_WARN = "message_warn";// 操作警告标识符

	public static final String SUCCESS_ADD = "Success.add";// 数据添加成功提示

	public static final String SUCCESS_EDIT = "Success.edit";// 数据修改成功提示

	public static final String SUCCESS_DELETE = "Success.delete";// 数据删除成功提示

	public static final String SUCCESS_RECOVER = "Success.recover";// 数据还原成功提示

	public static final String SUCCESS_START = "Success.start";// 开启成功提示

	public static final String SUCCESS_STOP = "Success.stop";// 暂停成功提示

	public static final String SUCCESS_BATCH_WORKBATCH = "Success.batch.workBatch";// 当前工作批次设置成功提示

	public static final String SUCCESS_BATCH_CLEAR = "Success.batch.clear";// 清除多余预订数据成功提示

	public static final String SUCCESS_BOOKINFORM_INFORMONE = "Success.bookInform.informOne";// 新书通报成功提示

	public static final String SUCCESS_BOOKINFORM_CANCEL = "Success.bookInform.cancelOne";// 取消通报成功提示

	public static final String SUCCESS_BOOKRECOMMEND_SETORDER = "Success.bookRecommend.setOrder";// 订购状态设置成功提示

	public static final String SUCCESS_READER_PASSWORD_FINDBACK = "Success.reader.password.findBack";// 密码发送至邮箱成功提示

	public static final String ERROR_BOOKRECOMMEND_SETORDER = "Error.bookRecommend.setOrder";// 订购失败提示

	public static final String SUCCESS_BOOKORDER_ORDER = "Success.BookOrder.order";// 图书预订成功提示

	public static final String SUCCESS_BOOKORDER_CANCEL = "Success.BookOrder.cancel";// 图书退订成功提示

	public static final String SUCCESS_ORDER_RECORD_EDIT = "Success.order.record.edit";// 预订记录修改成功

	public static final String SUCCESS_COLLECTION_STATUS_DEAL = "Success.collection.status.deal";// 馆藏状态处理成功提示

	public static final String SUCCESS_COLLECTION_REGIST = "Success.collection.regist";// 馆藏登记成功提示

	public static final String SUCCESS_COLLECTION_REJECT = "Success.collection.reject";// 馆藏剔除成功提示

	public static final String SUCCESS_COLLECTION_REPLACE = "Success.collection.replace";// 条码置换成功提示

	public static final String ERROR_ADD = "Error.save";// 数据添加失败提示

	public static final String ERROR_EDIT = "Error.edit";// 数据修改失败提示

	public static final String ERROR_DELETE = "Error.delete";// 数据删除失败提示

	public static final String ERROR_FILE_EXPORT = "Error.file.export";// 文件导出失败

	public static final String ERROR_FILE_IMPORT = "Error.file.import";// 文件导入失败

	public static final String ERROR_REPEAT_SUBMIT = "Error.repeat.submit";// 表单重复提交

	public static final String ERROR_NO_QUERY_CONDITION = "Error.no.query.condition";// 没有查询条件错误提示

	public static final String ERROR_BOOK_ORDER_CANCEL = "Error.BookOrder.cancel";// 图书已经退订再次预订错误提示

	public static final String WARN_BOOK_ORDER_NO_BOOK = "Warn.BookOrder.noBook";// 没有图书被预定警告提示

	public static final String ERROR_BATCH_WORKBATCH = "Error.batch.workBatch";// 设置验收批次为工作状态错误提示

	public static final String ERROR_ORDERBATCH_WORKBATCH = "Error.orderBatch.workBatch";// 设置预订批次为为工作状态错误提示

	public static final String ERROR_BIBLIOPARAMSET_Z3950 = "Error.biblioParamSet.z3950";// 设置预订批次为为工作状态错误提示

	public static final String ERROR_BIBLIOACCEPTANCEBOOK_DELETED_COLLECTION = "Error.biblioAcceptanceBook.deleted.collection";// 验收记录存在误删馆藏列表错误提示

	public static final String ERROR_Z3950_BEYOND = "Error.z3950Limit.beyond";// z3950下载条数限制错误提示

	public static final String WARN_USER_LIMIT = "Warn.user.limit";// 用户数量已达上限提示

	public static final String WARN_MARC_DATA_IS_NULL = "Warn.marc.data.is.null";// marc数据为空，无法进行详细编目操作

	public static final String WARN_BOOKCIRCULATETYPE_EXIST = "Warn.bookCirculateType.exist";// 文献类型存在提示

	public static final String WARN_COLLECTION_BARCODE_NO_NEED_REGIST = "Warn.collection.barcodeNoNeedRegist";// 该条码无须登记提示

	public static final String WARN_QUERY_NO = "Warn.query.no";// 没有查询到相关记录

	public static final String WARN_SYSDIC_EXIST = "Warn.sysDic.exist";// 数据字典存在提示

	public static final String WARN_SCHOOL_EXIST = "Warn.school.exist";// 学校存在提示

	public static final String WARN_SYSREGION_EXIST = "Warn.sysRegion.exist";// 数据字典存在提示

	public static final String WARN_SYSUSER_EXIST = "Warn.sysUser.exist";// 系统用户存在提示

	public static final String WARN_SYSPUBLISHER_EXIST = "Warn.sysPublisher.exist";// 出版社存在提示

	public static final String WARN_FEEDBACK_NODEAL = "Warn.feedBack.noDeal";// 反馈信息未处理删除提示

	public static final String WARN_BOOKSELLER_EXIST = "Warn.bookSeller.exist";// 书商存在提示

	public static final String WARN_BUDGET_EXIST = "Warn.budget.exist";// 资金预算存在提示

	public static final String WARN_BATCH_EXIST = "Warn.batch.exist";// 验收批次存在提示

	public static final String WARN_BATCH_WORKBATCH_NOTEXIST = "Warn.batch.workBatch.notExist";// 当前工作批次不存在提示

	public static final String WARN_READER_NOTEXIST = "Warn.reader.notExist";// 读者不存在提示

	public static final String WARN_READER_EMAIL_NOTBIND = "Warn.reader.email.notBind";// 读者尚未绑定邮箱

	public static final String WARN_BATCH_CURRENTBATCH_NOT_WORKBATCH = "Warn.batch.currentBatchNotWorkBatch";// 当前选中批次不是工作批次

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ORDERBATCH = "Warn.batch.currentBatchNotOrderBatch";// 当前预订批次不处于预订状态提示

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ORDER_ACCEPT_BATCH = "Warn.batch.currentBatchNotOrderAcceptBatch";// 当前预订批次不处于验收状态提示

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ACCEPTBATCH = "Warn.batch.currentBatchNotAcceptBatch";// 当前工作批次不处于验收状态提示

	public static final String WARN_BIBLIOPARAMSET_NOSET = "Warn.biblioParamSet.noSet";// 编目参数未设置提示

	public static final String WARN_SELLER_BATCH_FINISH_NO_DELETE = "Warn.seller.batch.finish.no.delete";// 书商征订书目已经完成无法删除提示

	public static final String WARN_ORDER_BATCH_HAS_ORDER_NO_EDIT = "Warn.order.batch.has.order.no.edit";// 预定批次已经预订无法修改提示

	public static final String WARN_ACCEPT_BATCH_HAS_ACCEPT_NO_EDIT = "Warn.accept.batch.has.accept.no.edit";// 验收批次已经验收无法修改提示

	public static final String WARN_SELLER_BATCH_FINISH_NO_EDIT = "Warn.seller.batch.finish.no.edit";// 书商征订书目已经完成无法修改提示

	public static final int BIBLIO_AUTHORIZE_TYPE = 2;// 编目授权类型

	public static final String WARN_BIBLIOAUTHORIZE_EXIST = "Warn.biblioAuthorize.exist";// 编目授权存在提示

	public static final String ERROR_BIBLIOAUTHORIZE_NO_ALLOW = "Error.biblioAurhorize.no.allow";// 编目未得到授权

	public static final String ERROR_BIBLIOAUTHORIZE_BEYOND = "Error.biblioAurhorize.beyond";// 实际编目册数超过申请册数

	public static final String WARN_COLLECTION_NOTEXIST = "Warn.collection.notExist";// 馆藏信息不存在提示

	public static final String WARN_COLLECTION_NOTINSTATUS = "Warn.collection.notInStatus";// 馆藏状态并非在馆状态提示

	public static final String WARN_COLLECTION_NEWBARCODEEXIST = "Warn.collection.newBarcodeExist";// 新条码号已经存在提示

	public static final String WARN_COLLECTION_ISLEND_STATUS = "Warn.collection.isLendStatus";// 馆藏外借状态

	public static final String WARN_COLLECTION_ISLOSE_STATUS = "Warn.collection.isLoseStatus";// 馆藏丢失状态

	public static final String WARN_COLLECTION_HAS_PAY = "Warn.collection.has.pay";// 馆藏存在罚款

	public static final String WARN_COLLECTION_LEND_NO_DELETE = "Warn.collection.lendNoDelete";// 馆藏外借状态下无法删除提示

	public static final String ERROR_COLLECTION_BARCODE_REPEAT = "Error.collection.barcode.repeat";// 条码号重复

	public static final String WARN_COLLECTION_ISDELETED = "Warn.collection.isDeleted";// 属于馆藏误删记录的警告提示

	public static final String WARN_READPARAMSET_EXIST = "Warn.readParamSet.exist";// 阅览参数设置代码存在警告提示

	public static final String WARN_READPARAMSET_HASCOLLECTIONPLACE = "Warn.readParamSet.hasCollectionPlace";// 对应馆藏地阅览参数存在警告提示

	public static final int COLLECTION_NOTEXIST_MARK = 1;// 馆藏信息不存在标志

	public static final int COLLECTION_NOTINSTATUS_MARK = 2;// 馆藏状态并非在馆状态标志

	public static final int COLLECTION_NEWBARCODEEXIST_MARK = 3;// 新条码号已经存在标志

	public static final String MD5 = "MD5";// md5算法标识

	public static final int PAGE_SIZE = 10;// 每页显示记录条数

	public static final String ID = "id"; // id属性

	public static final String SUCCESS_LIST = "success_list";// excel解析成功记录标识

	public static final String FAIL_LIST = "fail_list";// excel解析失败记录标识

	public static final String ROW_NUM = "row_num";// excel对应行号

	public static final String PAGE_KEY = "page";// 分页数据键值

	public static final String TOKEN_KEY = "token_key";// 令牌键值

	public static final String REPEAT_SUBMIT = "Error.repeat.submit";// 表单重复提交

	public static final String LOGIN_ERROR = "login_error";// 登陆出错

	public static final String LOGIN_ERROR_INFO = "用户名或密码错误!";// 登录提示

	public static final String ORGNIZE_TYPE = "orgnize_type";// 组织类型

	public static final String LOCAL_USER = "local_user";// 当前登录用户键值

	public static final int SCHOOL_TYPE = 1;// 学校类型

	public static final int BUDGET_TYPE = 4;// 资金预算类型

	public static final int SCHOOL_BILL_TYPE = 5;// 票据类型

	public static final int SCHOOL_BILL_PAY_TYPE = 6;// 付款方式类型

	public static final int MARC_FORMAT = 7;// 马克类型

	public static final String UNIMARC = "unimarc";// unimarc格式名

	public static final int BOOK_TYPE = 8;// 资料类型

	public static final int IS_ALL = 0;// 索书号应用于所有人

	public static final int IS_BOOK = 1;// 图书

	public static final int IS_MAGAZINE = 2;// 期刊

	public static final int NO_BOOK = 3;// 非书资料

	public static final int BATCH_STATUS = 9;// 验收批次所有状态

	public static final int SELLER_CATALOG_STATUS = 32;// 书商征订目录所有状态

	public static final int ORDER_BATCH_STATUS = 33;// 图书预订批次所有状态

	public static final int ORDER_TYPE = 34;// 图书预订记录类型(预订/退订)

	public static final int CHINA_LIB_CLASS_TYPE = 36;// 中图分类法在数据字典中的类型

	// 图书验收类型批次
	public static final int BATCH_CHECK_STATUS = 1;// 验收批次默认初始状态(验收)

	public static final int BATCH_FINISH_STATUS = 2;// 验收批次完成状态

	public static final int BATCH_HISTORY_STATUS = 3;// 验收批次历史状态

	// 书商征订类型批次
	public static final int BATCH_RECEIVE_STATUS = 1;// 书商征订批次接收状态

	// 图书预订类型批次
	public static final int ORDER_BATCH_ORDER_STATUS = 1;// 图书预订批次预订状态

	public static final int ORDER_BATCH_CHECK_STATUS = 2;// 图书预订批次验收状态

	public static final int ORDER_BATCH_FINISH_STATUS = 3;// 图书预订批次完成状态

	public static final int ORDER_BATCH_HISTORY_STATUS = 4;// 图书预订批次历史状态

	// 书商征订类型批次
	public static final int SELLER_BATCH_RECEIVE_STATUS = 1;// 书商征订批次接收状态

	public static final int SELLER_BATCH_FINISH_STATUS = 2;// 书商征订批次完成状态

	public static final int SELLER_BATCH_HISTORY_STATUS = 3;// 书商征订批次历史状态

	public static final int CURRENT_WORK_BATCH = 1;// 当前工作批次

	public static final int IS_COMPANY = 1;// 公司

	public static final int IS_DSS = 2;// 教育局

	public static final int IS_SCHOOL = 3;// 学校

	public static final String PAGE_PARAM = "param";// 分页参数标记

	public static final String ERROR_FILE_CREATE = "Error.file.create";// 文件创建失败

	public static final String ERROR_FILE_PARSE = "Error.file.parse";// 文件解析失败

	public static final String ERROR_FILE_NOTFOUND = "Error.file.notFound";// 找不到指定文件

	public static final String ERROR_DEPT_EXIST = "Error.dept.exist";// 读者组织存在提示

	public static final int MENU_ONE = 1;// 一级菜单

	public static final int MENU_TWO = 2;// 二级菜单

	public static final int MENU_THREE = 3;// 三级菜单

	public static final String ERROR_READERTYPE_EXIST = "Error_readertype_exist";// 读者类型存在提示

	public static final String SALT = "salt";// 盐值

	public static final String USER_NAME_KEY = "user_name_key";// session用户名键值

	public static final String DEFAULT_USERNAME = "cadmin";// 公司后台默认用户户名

	public static final int BIBLIO_AUTHORIZE_INIT_COUNT = 0;// 编目授权初始数量

	public static final int DELETES_KEY = 1;// 假删除有效键

	public static final String COMP_PATH = "/comp/";// 公司目录请求

	public static final String MANA_PATH = "/maneger/";// 管理目录请求

	public static final String DSS_PATH = "/dss/";// 决策目录请求

	public static final int FEED_BACK_TYPE = 3;// 反馈信息状态

	public static final int NOT_DEAL = 1;// 反馈信息未处理

	public static final int IS_DEAL = 2;// 反馈信息已处理

	public static final int IS_VALID = 1;// 可用标识

	public static final int NO_DELETE = 1;// 没有被假删

	public static final int IS_DELETE = 2;// 已经假删

	public static final int BIBLIO_DIRECT = 1;// 编目状态-直接接收

	public static final int BIBLIO_ORIGINAL = 2;// 编目状态-原编

	public static final int BIBLIO_RECEIVE_SELLER = 3;// 接收书商

	public static final int BIBLIO_Z3950_ADD = 4;// 编目状态-z3950新增

	public static final int BIBLIO_Z3950_MERGE = 5;// 编目状态-z3950合并

	public static final int NO_REGIST = 1;// 馆藏还没有登记

	public static final int HAD_REGIST = 2;// 馆藏已经登记过

	public static final int BARCODE_SETTING = 12;// 条码参数设置类型

	public static final int BARCODE_TYPE = 13;// 条码类型

	public static final int MEDIA_TYPE = 14;// 介质类型

	public static final int BOOK_SOURCE = 15;// 文献来源

	public static final int BIND_INFO = 16;// 装帧形式

	public static final int REGION_PROVINCE = 1;// 省级区划

	public static final int REGION_CITY = 2;// 市级区划

	public static final int REGION_COUNTY = 3;// 县级区划

	public static final int COLLECTION_INIT_LEND_NUM = 0;// 馆藏初始借阅量

	public static final int COLLECTION_STATUS = 22;// 馆藏所有状态

	public static final int COLLECTION_INIT_STATUS = 1;// 馆藏初始状态(在馆)

	public static final int COLLECTION_LEND_STATUS = 2;// 馆藏外借状态

	public static final int COLLECTION_LOSE_STATUS = 3;// 馆藏丢失状态

	public static final int COLLECTION_DAMAGE_STATUS = 4;// 馆藏损坏状态

	public static final int COLLECTION_REJECT_STATUS = 5;// 馆藏剔除状态

	public static final int COLLECTION_OTHER_STATUS = 6; // 馆藏其他状态

	public static final int COLLECTION_TYPE = 17;// 馆藏类型

	public static final int COLLECTION_INIT_TYPE = 1;// 馆藏初始类型

	public static final int COLLECTION_PLACE_NO_REGIST = 1;// 馆藏地不需要登记

	public static final int COLLECTION_PLACE_IS_REGIST = 2;// 馆藏地需要登记

	public static final int COLLECTION_NORMAL_STATE = 1;// 馆藏正常标志(未批量删除)

	public static final int COLLECTION_DELETE_STATE = 2;// 馆藏批量删除标志

	public static final int INIT_COPIES = 1;// 初始复本数

	public static final int INIT_VOL_NUM = 1;// 初始卷册数量

	public static final String INIT_VOL_INFO = "1";// 初始化卷册信息

	public static final int LOSE_FEE_TYPE = 18;// 丢书罚款方式

	public static final int LOSE_PAY_TYPE = 19;// 丢书罚款类型

	public static final int RENEW_TYPE = 20;// 续期计算方法

	public static final int COLLECTION_PLACE_REGIST = 21;// 馆藏是否需登记

	public static final int IS_DEFAULT = 1;// 馆藏地点和文献类型默认标识

	public static final int BIBLIO_SHARE = 23;// 编目数据是否共享

	public static final int BIBLIO_IS_SHARE = 1;// 书目数据共享

	public static final int BIBLIO_NO_SHARE = 2;// 书目数据不共享

	public static final int READER_STATUS = 24;// 读者状态

	public static final int SEX_STATUS = 25;// 性别状态

	public static final int BOOK_RECOMMEND_STATUS = 26;// 图书荐购状态

	public static final int BOOK_HAD_INFORM = 1;// 新书已经通报状态

	public static final String XLS = ".xls";// excel后缀2003

	public static final String XLSX = ".xlsx";// excel后缀2007

	public static final int BOOK_RECOMMEND_NODEAL = 1;// 图书荐购未处理

	public static final int BOOK_RECOMMEND_ORDER = 2;// 图书荐购已订购

	public static final int BOOK_RECOMMEND_BUY = 3;// 图书荐购已购买

	public static final int BATCH_TYPE_ORDER = 1;// 订购

	public static final int BATCH_TYPE_ACCEPT = 2;// 验收

	public static final int BATCH_TYPE_BOOK_SELLER = 3;// 书商书目批次

	public static final int BATCH_TYPE_SERIES_ORDER = 4;// 期刊订购

	// 详细编目marc重要字段
	public static final String MARC_HEA = "HEA";// 头标区

	public static final String MARC_000 = "000";// 头标区

	public static final String MARC_001 = "001";// 记录控制号

	public static final String MARC_005 = "005";// 记录处理时间标识

	public static final String MARC_010 = "010";// isbn

	public static final String MARC_100 = "100";// 通用处理数据

	public static final String MARC_101 = "101";// 作品语种

	public static final String MARC_102 = "102";// 出版或制作国别

	public static final String MARC_105 = "105";// 专著

	public static final String MARC_106 = "106";// 文字资料形态特征

	public static final String MARC_200 = "200";// 题名与责任者项

	public static final String MARC_210 = "210";// 出版发行项

	public static final String MARC_215 = "215";// 载体形态项

	public static final String MARC_225 = "225";// 丛编项

	public static final String MARC_330 = "330";// 提要或文摘

	public static final String MARC_606 = "606";// 普通主题

	public static final String MARC_690 = "690";// 中图分类号

	public static final String MARC_701 = "701"; // 载体形态项

	public static final String MARC_801 = "801";// 载体形态项

	public static final String MARC_905 = "905";// 馆藏信息

	public static final String MARC_011 = "011";// ISSN

	public static final String MARC_092 = "092";// 订购号

	public static final String MARC_326 = "326";// 出版频率

	// 旧书统计清单导出列头
	public static final Map<String, String> getBiblioOldBookTitles() {
		Map<String, String> biblioOldBookTitles = new LinkedHashMap<String, String>();
		biblioOldBookTitles.put("0", "序号");
		biblioOldBookTitles.put("1", "ISBN");
		biblioOldBookTitles.put("2", "标题");
		biblioOldBookTitles.put("3", "著者");
		biblioOldBookTitles.put("4", "价格");
		biblioOldBookTitles.put("5", "数量");
		biblioOldBookTitles.put("6", "总金额");
		return biblioOldBookTitles;
	}

	// 新书通报清单导出列头
	// public static final Map<String, String> bookInformTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// bookInformTitles.put("0", "序号");
	// bookInformTitles.put("1", "ISBN");
	// bookInformTitles.put("2", "书名");
	// bookInformTitles.put("3", "著者");
	// bookInformTitles.put("4", "分类号");
	// }

	public static final Map<String, String> getBookInformTitles() {
		Map<String, String> bookInformTitles = new LinkedHashMap<String, String>();
		bookInformTitles.put("0", "序号");
		bookInformTitles.put("1", "ISBN");
		bookInformTitles.put("2", "书名");
		bookInformTitles.put("3", "著者");
		bookInformTitles.put("4", "分类号");
		return bookInformTitles;
	}

	// 图书荐购清单列头
	// public static final Map<String, String> bookRecommendTitls = new
	// LinkedHashMap<String, String>();
	// static {
	// bookRecommendTitls.put("-1", "序号");
	// bookRecommendTitls.put("0", "ISBN");
	// bookRecommendTitls.put("1", "分类号");
	// bookRecommendTitls.put("2", "题名");
	// bookRecommendTitls.put("3", "著者");
	// bookRecommendTitls.put("4", "主题");
	// bookRecommendTitls.put("5", "出版社");
	// bookRecommendTitls.put("6", "出版日期");
	// bookRecommendTitls.put("7", "类型");
	// bookRecommendTitls.put("8", "处理状态");
	// }

	public static final Map<String, String> getBookRecommendTitles() {
		Map<String, String> bookRecommendTitls = new LinkedHashMap<String, String>();
		bookRecommendTitls.put("-1", "序号");
		bookRecommendTitls.put("0", "ISBN");
		bookRecommendTitls.put("1", "分类号");
		bookRecommendTitls.put("2", "题名");
		bookRecommendTitls.put("3", "著者");
		bookRecommendTitls.put("4", "主题");
		bookRecommendTitls.put("5", "出版社");
		bookRecommendTitls.put("6", "出版日期");
		bookRecommendTitls.put("7", "类型");
		bookRecommendTitls.put("8", "处理状态");
		return bookRecommendTitls;
	}

	// 验收统计列头
	public static final Map<String, String> acceptCountTitles = new LinkedHashMap<String, String>();
	static {
		acceptCountTitles.put("0", "序号");
		acceptCountTitles.put("1", "ISBN");
		acceptCountTitles.put("2", "题名");
		acceptCountTitles.put("3", "验收人");
		acceptCountTitles.put("4", "验收时间");
		acceptCountTitles.put("5", "验收册数");
	}

	// 书目分类统计列头
	public static final Map<String, String> biblioCountTitles = new LinkedHashMap<String, String>();
	static {
		biblioCountTitles.put("0", "序号");
		biblioCountTitles.put("1", "分类号");
		biblioCountTitles.put("2", "数量");
	}

	public static final Map<String, String> z3950DownLoadCountTitles = new LinkedHashMap<String, String>();
	static {
		z3950DownLoadCountTitles.put("0", "序号");
		z3950DownLoadCountTitles.put("1", "操作员");
		z3950DownLoadCountTitles.put("2", "国家");
		z3950DownLoadCountTitles.put("3", "Z3950名称");
		z3950DownLoadCountTitles.put("4", "数量");
	}

	// 馆藏清单列头
	// public static final Map<String, String> collectionBillTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionBillTitles.put("0", "序号");
	// collectionBillTitles.put("1", "条码号");
	// collectionBillTitles.put("2", "分类号");
	// collectionBillTitles.put("3", "题名");
	// collectionBillTitles.put("4", "作者");
	// collectionBillTitles.put("5", "ISBN");
	// collectionBillTitles.put("6", "出版社");
	// collectionBillTitles.put("7", "出版时间");
	// collectionBillTitles.put("8", "单价");
	// collectionBillTitles.put("9", "馆藏状态");
	// collectionBillTitles.put("10", "入馆时间");
	// collectionBillTitles.put("11", "处理时间");
	// collectionBillTitles.put("12", "操作员");
	// }

	public static final Map<String, String> getCollectionBillTitles() {
		Map<String, String> collectionBillTitles = new LinkedHashMap<String, String>();
		collectionBillTitles.put("0", "序号");
		collectionBillTitles.put("1", "条码号");
		collectionBillTitles.put("2", "分类号");
		collectionBillTitles.put("3", "题名");
		collectionBillTitles.put("4", "作者");
		collectionBillTitles.put("5", "ISBN");
		collectionBillTitles.put("6", "出版社");
		collectionBillTitles.put("7", "出版时间");
		collectionBillTitles.put("8", "单价");
		collectionBillTitles.put("9", "馆藏状态");
		collectionBillTitles.put("10", "入馆时间");
		collectionBillTitles.put("11", "处理时间");
		collectionBillTitles.put("12", "操作员");
		return collectionBillTitles;
	}

	// 馆藏分类统计列头
	// public static final Map<String, String> collectionClassTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionClassTitles.put("0", "序号");
	// collectionClassTitles.put("1", "分类");
	// collectionClassTitles.put("2", "种数");
	// collectionClassTitles.put("3", "册数");
	// collectionClassTitles.put("4", "单价和");
	// }

	public static final Map<String, String> getCollectionClassTitles() {
		Map<String, String> collectionClassTitles = new LinkedHashMap<String, String>();
		collectionClassTitles.put("0", "序号");
		collectionClassTitles.put("1", "分类");
		collectionClassTitles.put("2", "种数");
		collectionClassTitles.put("3", "册数");
		collectionClassTitles.put("4", "单价和");
		return collectionClassTitles;
	}

	// public static final Map<String, String> collectionPlaceTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionPlaceTitles.put("0", "序号");
	// collectionPlaceTitles.put("1", "馆藏地点");
	// collectionPlaceTitles.put("2", "分类");
	// collectionPlaceTitles.put("3", "种数");
	// collectionPlaceTitles.put("4", "册数");
	// collectionPlaceTitles.put("5", "单价和");
	// }

	public static final Map<String, String> getCollectionPlaceTitles() {
		Map<String, String> collectionPlaceTitles = new LinkedHashMap<String, String>();
		collectionPlaceTitles.put("0", "序号");
		collectionPlaceTitles.put("1", "馆藏地点");
		collectionPlaceTitles.put("2", "分类");
		collectionPlaceTitles.put("3", "种数");
		collectionPlaceTitles.put("4", "册数");
		collectionPlaceTitles.put("5", "单价和");
		return collectionPlaceTitles;
	}

	// public static final Map<String,String> logCountTitles=new
	// LinkedHashMap<String, String>();
	// static{
	// logCountTitles.put("0", "序号");
	// logCountTitles.put("1", "操作员");
	// logCountTitles.put("2", "操作类型");
	// logCountTitles.put("3", "数量");
	// }

	public static final Map<String, String> getLogCountTitles() {
		Map<String, String> logCountTitles = new LinkedHashMap<String, String>();
		logCountTitles.put("0", "序号");
		logCountTitles.put("1", "操作员");
		logCountTitles.put("2", "操作类型");
		logCountTitles.put("3", "数量");
		return logCountTitles;
	}

	// 读者财经excel列头
	public static final Map<String, String> getReaderFinanceTitles() {
		Map<String, String> readerFinanceTitles = new LinkedHashMap<String, String>();
		readerFinanceTitles.put("0", "序号");
		readerFinanceTitles.put("1", "罚款类型");
		readerFinanceTitles.put("2", "题名");
		readerFinanceTitles.put("3", "条码号");
		readerFinanceTitles.put("4", "索书号");
		readerFinanceTitles.put("5", "金额");
		readerFinanceTitles.put("6", "发生日期");
		return readerFinanceTitles;
	}

	// 收款统计excel列头
	public static final Map<String, String> getReceiveMoneyCountTitles() {
		Map<String, String> receiveMoneyCountTitles = new LinkedHashMap<String, String>();
		receiveMoneyCountTitles.put("0", "序号");
		receiveMoneyCountTitles.put("1", "操作员");
		receiveMoneyCountTitles.put("2", "金额");
		return receiveMoneyCountTitles;
	}

	// 财经类型统计excel列头
	public static final Map<String, String> getFinanceClassCountTitles() {
		Map<String, String> bookFinanceClassCountTitles = new LinkedHashMap<String, String>();
		bookFinanceClassCountTitles.put("0", "序号");
		bookFinanceClassCountTitles.put("1", "财经类型");
		bookFinanceClassCountTitles.put("2", "金额");
		return bookFinanceClassCountTitles;
	}

	public static final Map<String, String> getBookFinanceClassCountTitles() {
		Map<String, String> bookFinanceClassCountTitles = new LinkedHashMap<String, String>();
		bookFinanceClassCountTitles.put("0", "序号");
		bookFinanceClassCountTitles.put("1", "文献类型名称");
		bookFinanceClassCountTitles.put("2", "金额");
		return bookFinanceClassCountTitles;
	}

	public static final String READER_FINANCE_EXPORT_NAME = "读者财经管理";// 读者财经管理清单导出名称

	public static final String RECEIVE_MONEY_COUNT_EXPORT_NAME = "收款统计";// 收款统计清单导出名称

	public static final String FINANCE_CLASS_COUNT_EXPORT_NAME = "财经类型统计";// 财经类型清单导出名称

	public static final String BOOK_FINANCE_CLASS_COUNT_EXPORT_NAME = "文献分类财经统计";// 文献文类财经统计清单导出名称

	public static final String LOG_COUNT_EXPORT_NAME = "日志统计";// 日志统计清单导出名称

	public static final String BOOK_INFORM_EXPORT_NAME = "新书通报内容清单";// 新书通报清单导出名称

	public static final String BOOK_RECOMMEND_EXPORT_NAME = "图书荐购列表";// 图书荐购清单导出名称

	public static final String SERIES_BOOK_RECOMMEND_EXPORT_NAME = "期刊荐购列表";// 期刊荐购清单导出名称

	public static final String BIBLIO_OLD_BOOK_EXPORT_NAME = "旧书统计";// 旧书统计导出名称

	public static final String ACCEPT_COUNT_EXPORT_NAME = "验收统计";// 验收统计导出名称

	public static final String COLLECTION_BILL_EXPORT_NAME = "馆藏清单";// 馆藏清单导出名称

	public static final String COLLECTION_CLASS_EXPORT_NAME = "馆藏分类统计";// 馆藏分类统计导出名称

	public static final String COLLECTION_PLACE_EXPORT_NAME = "馆藏地点统计";// 馆藏地点统计导出名称

	public static final String OVERDUE_LIST_NAME = "催还清单";// 催还清单导出名称

	public static final String BIBLIO_COUNT_EXPORT_NAME = "书目分类统计";// 书目分类统计导出名称

	public static final String Z3950_DOWNLOAD_COUNT_EXPORT_NAME = "z3950下载统计";// z3950下载统计导出名称

	public static final String READER_BARCODE_NOEXIST = "reader_barcode_noexist"; // 读者卡号不存在提示

	public static final String COLLECTION_BARCODE_NOEXIST = "collection_barcode_noexist"; // 馆藏条码不存在提示

	public static final int ATTACHMENT_MARK = 27; // 附件标识

	public static final int ATTACHMENT_MARK_KEY = 1; // 附件随书外借

	public static final int RETURNED_MARK_KEY = 1; // 已还

	public static final int LEND_MARK_KEY = 2; // 借出

	public static final int LEND_RULE_TYPE = 28; // 借书规则类型

	public static final int ORDER_SOURCE = 41;// 预订来源数据字典类型

	public static final int LEND_RENEW_COUNT = 0; // 初始化续借次数

	public static final int LEND_RULE_TYPE_ONE = 1; // 借书规则类型为一的普通外借

	public static final String LEND_SUCCESS = "lend_success"; // 借书成功

	public static final String LEND_SUPERIOR_LIMIT = "lend_superior_limit"; // 借书已达上限

	public static final String READER_EXPIRED = "reader_expired"; // 读者过期

	public static final String COLLECTION_LEND = "collection_lend"; // 图书不在馆

	public static final String LEND_BARCODE_NOEXIST = "lend_barcode_noexist"; // 借阅记录不存在提示

	public static final String RETURNED_SUCCESS = "returned_success";// 还书成功提示

	public static final String LEND_COLLECTION_LIMIT = "lend_collection_limit"; // 读者不能借阅该馆图书提示

	public static final String WARN_SERIESCURRENCY_EXIST = "Warn.seriesCurrency.exist";// 货币（期刊）汇率已存在

	public static final String WARN_SERIESCYCLE_EXIST = "Warn.seriesCycle.exist";// 周期代码已经存在

	public static final int BOOK_ORDER_STATUS = 1;// 图书预订状态

	public static final int BOOK_CANCEL_ORDER_STATUS = 2;// 图书退订状态

	public static final int CHAESET = 30;// 数据字符编码集

	public static final int SERIES_TYPE = 31;// 期刊类别

	public static final int SERIES_ORDER_TYPE = 35;// 期刊预定类型

	public static final int SERIES_ORDER_TYPE_RESEVATION = 1;// 预定

	public static final int SERIES_ORDER_TYPE_RENEW = 2;// 续订

	public static final int SERIES_ORDER_TYPE_UNSUBSCRIBE = 3;// 退订

	public static final int SERIES_ORDER_TYPE_STOP = 4;// 停订

	public static final int SERIES_ORDER_TYPE_DIRECTLY = 5;// 直接记到

	public static final String SERIES_ORDER_UNSUBSCRIBE_ERROR = "Warn.unsubscribe.error";// 停订记录不能退订

	public static final String SUCCESS_SERIES_ORDER_STOP = "Success.seriesOrder.stop";// 期刊停订成功

	public static final String SUCCESS_SERIES_ORDER_RENEW = "Warn.seriesOrder.renew";// 期刊续订成功

	public static final String SUCCESS_SERIES_ORDER_RENEW_SIZE = "Warn.seriesOrder.renew.size";

	public static final int READERSTAT_INIT_PREPAY = 0;// 卡户初始化押金

	public static final int READERSTAT_INIT_TOTAL_LEND_NUM = 0;// 卡户初始化押金借阅数量

	// public static final Map<String, String> overdueListTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// overdueListTitles.put("0", "序号");
	// overdueListTitles.put("1", "读者证号");
	// overdueListTitles.put("2", "读者姓名");
	// overdueListTitles.put("3", "读者组织");
	// overdueListTitles.put("4", "读者类型");
	// overdueListTitles.put("5", "书名");
	// overdueListTitles.put("6", "条码号");
	// overdueListTitles.put("7", "借出时间");
	// overdueListTitles.put("8", "应还时间");
	// }

	public static final Map<String, String> getOverdueListTitles() {
		Map<String, String> overdueListTitles = new LinkedHashMap<String, String>();
		overdueListTitles.put("0", "序号");
		overdueListTitles.put("1", "读者证号");
		overdueListTitles.put("2", "读者姓名");
		overdueListTitles.put("3", "读者组织");
		overdueListTitles.put("4", "读者类型");
		overdueListTitles.put("5", "书名");
		overdueListTitles.put("6", "条码号");
		overdueListTitles.put("7", "借出时间");
		overdueListTitles.put("8", "应还时间");
		return overdueListTitles;
	}

	public static final int SERIES_ACCEPT_TYPE = 37;// 预定验收数量类型

	public static final int SERIES_ACCEPT_RESERVATION = 1;// 预定验收 reservation

	public static final int SERIES_ACCEPT_DIRECTLY = 2;// 直接验收directly

	public static final int SERIES_ACCEPT_STATE = 38;// 期刊记到状态（数据类型）

	public static final int SERIES_ACCEPT_STATE_NOT_IN = 1;// 未记到

	public static final int SERIES_ACCEPT_STATE_IN = 2;// 在馆

	public static final int SERIES_ACCEPT_STATE_NOT_HERE = 3;// 未到齐

	public static final int SERIES_ACCEPT_STATE_BINDING = 4;// 装订

	public static final int SERIES_ACCEPT_STATE_PUSH_LACK = 5;// 催缺

	public static final int SERIES_ACCEPT_STATE_DELAY = 6;// 推迟

	public static final int SERIES_ACCEPT_STATE_PUSH_NOT = 7;// 催不到

	public static final int SERIES_ACCEPT_STATE_CLOSURE = 8;// 停刊

	public static final int SERIES_ACCEPT_STATE_REFUND = 9;// 退款

	public static final int SERIES_ACCEPT_STATE_LOST = 10;// 丢失

	public static final String READER_BATCH_SUCCESS = "reader_batch_success"; // 读者批处理成功

	public static final Integer LEND_STATUS = 39; // 读者借阅文献流通状态

	public static final Integer INIT_PERSONNUM = 10; // 读者借阅排行榜初始化统计人数

	public static Integer SERIES_MERGESIGN_FUSION = 1;// 合刊

	public static Integer SERIES_MERGESIGN_NOT_FUSION = 2;// 不是合刊

	public static Integer SERIES_BIND_STATUS = 40;// 装订状态

	public static Integer SERIES_BIND_STATUS_BIND = 1;// 装订

	public static Integer SERIES_BIND_STATUS_SUBMIT = 2;// 交送

	public static Integer SERIES_BIDN_STATUS_TIBET = 3;// 入藏

	public static Integer LEND_STATUS_RETURN_BACK = 1;// 已还

	public static Integer LEND_STATUS_LEND = 2;// 借出

	public static Integer LEND_STATUS_LOSE = 3;// 丢失

	public static Integer LEND_STATUS_BROKEN = 4;// 剔除

	public static Integer LEND_STATUS_OTHER = 5;// 其他

	public static String LOSE_SUCCESS = "lose_success"; // 丢书处理

	public static String BROKEN_SUCCESS = "broken_success"; // 污损处理

	public static String SERIES_BIND_SEND_SUCCESS = "series_bind_send_success";// 期刊交送成功

	public static String READER_INIT_PASSWORD = "123456"; // 读者默认密码

	public static Integer READER_STATUS_VALID = 1;// 有效

	public static Integer READER_STATUS_TEST = 2;// 验证

	public static Integer READER_STATUS_LOSE = 3;// 丢失

	public static Integer READER_STATUS_STOP = 4;// 暂停

	public static Integer READER_STATUS_LOGOUT = 5;// 注销

	public static String SYS_MESSAGE_HEADER = "您的图书<";// 信息消息发送头

	public static final String BOOK_MARK_PRINT_ORDER_BY_DEFAULT = "default";// 书标打印默认排序方式

	public static final String BOOK_MARK_PRINT_ORDER_BY_CALLNO = "call_no";// 书标打印按照索书号排序

	public static final String BOOK_MARK_PRINT_ORDER_BY_BARCODE = "barcode";// 书标打印按照条码号排序

	public static final String BOOK_MARK_PRINT_ORDER_BY_TIME = "create_time";// 书标打印按照入藏时间排序

	// public static final Map<String, String> BOOK_MARK_PRINT_ORDER_WAY = new
	// LinkedHashMap<String, String>();// 书标打印排序方式
	// static {
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_DEFAULT, "默认");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_CALLNO, "索书号");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_BARCODE, "条码号");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_TIME, "入藏时间");
	// }

	public static final Map<String, String> getBookMarkPrintOrderWay() {
		Map<String, String> BOOK_MARK_PRINT_ORDER_WAY = new LinkedHashMap<String, String>();
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_DEFAULT, "默认");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_CALLNO, "索书号");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_BARCODE, "条码号");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_TIME, "入藏时间");
		return BOOK_MARK_PRINT_ORDER_WAY;
	}

	public static final int BOOK_MARK_PRINT_BARCODE_NO = 0;

	public static final int BOOK_MARK_PRINT_BARCODE_FRONT = 1;

	public static final int BOOK_MARK_PRINT_BARCODE_BEHIND = 2;

	// public static final List<String> BOOK_MARK_PRINT_BARCODE_WAY = new
	// LinkedList<String>();// 书标打印条码显示格式
	//
	// static {
	// BOOK_MARK_PRINT_BARCODE_WAY.add("否");
	// BOOK_MARK_PRINT_BARCODE_WAY.add("条码在前");
	// BOOK_MARK_PRINT_BARCODE_WAY.add("条码在后");
	// }

	public static final List<String> getBookMarkPrintBarcodeWay() {
		List<String> BOOK_MARK_PRINT_BARCODE_WAY = new LinkedList<String>();
		BOOK_MARK_PRINT_BARCODE_WAY.add("否");
		BOOK_MARK_PRINT_BARCODE_WAY.add("条码在前");
		BOOK_MARK_PRINT_BARCODE_WAY.add("条码在后");
		return BOOK_MARK_PRINT_BARCODE_WAY;
	}

	public static final int ORDER_OPTION = 42; // WebOpac检索排序方式

	public static final int ORDER_MODE = 43; // 检索排序方式

	public static final int ORDER_OPTION_CLASS_NO = 1; // WebOpac检索排序方式(分类号)

	public static final int ORDER_OPTION_AUTHOR = 2; // WebOpac检索排序方式(作者)

	public static final int ORDER_MODE_ASCENDING = 1; // 检索排序方式(升序)

	public static final int ORDER_MODE_DESCENDING = 2; // 检索排序方式(降序)

	// public static final Map<String, String> SERIES_REPORT_ORDER_ALL_SORT_WAY
	// = new LinkedHashMap<String, String>();// 订购单报表排序方式
	//
	// static {
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderNo", "订购号");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.title", "题名");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("publisher", "出版社");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("bookSellerId", "书商");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderTime", "订购时间");
	// }

	public static final Map<String, String> getSeriesReportOrderAllSortWay() {
		Map<String, String> SERIES_REPORT_ORDER_ALL_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderNo", "订购号");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.title", "题名");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("publisher", "出版社");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("bookSellerId", "书商");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderTime", "订购时间");
		return SERIES_REPORT_ORDER_ALL_SORT_WAY;
	}

	public static final String SERIES_REPORT_ORDER_ALL_EXPORT_NAME = "订购单报表";

	// public static final Map<String, String> REPORT_ORDER_ALL_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_ALL_LIST.put("-1", "序号");
	// REPORT_ORDER_ALL_LIST.put("0", "订购号");
	// REPORT_ORDER_ALL_LIST.put("1", "分类号");
	// REPORT_ORDER_ALL_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_ALL_LIST.put("3", "题名");
	// REPORT_ORDER_ALL_LIST.put("4", "出版社");
	// REPORT_ORDER_ALL_LIST.put("5", "分馆代码");
	// REPORT_ORDER_ALL_LIST.put("6", "书商代码");
	// REPORT_ORDER_ALL_LIST.put("7", "预定年份");
	// REPORT_ORDER_ALL_LIST.put("8", "订购时间");
	// REPORT_ORDER_ALL_LIST.put("9", "出版期数");
	// REPORT_ORDER_ALL_LIST.put("10", "复本数");
	// REPORT_ORDER_ALL_LIST.put("11", "价格");
	// REPORT_ORDER_ALL_LIST.put("12", "原套价");
	// REPORT_ORDER_ALL_LIST.put("13", "总价");
	// REPORT_ORDER_ALL_LIST.put("14", "出版周期");
	// REPORT_ORDER_ALL_LIST.put("15", "年价");
	// REPORT_ORDER_ALL_LIST.put("16", "索书号");
	// }

	public static final Map<String, String> getReportOrderAllList() {
		Map<String, String> REPORT_ORDER_ALL_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_ALL_LIST.put("-1", "序号");
		REPORT_ORDER_ALL_LIST.put("0", "订购号");
		REPORT_ORDER_ALL_LIST.put("1", "分类号");
		REPORT_ORDER_ALL_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_ALL_LIST.put("3", "题名");
		REPORT_ORDER_ALL_LIST.put("4", "出版社");
		REPORT_ORDER_ALL_LIST.put("5", "分馆代码");
		REPORT_ORDER_ALL_LIST.put("6", "书商代码");
		REPORT_ORDER_ALL_LIST.put("7", "预定年份");
		REPORT_ORDER_ALL_LIST.put("8", "订购时间");
		REPORT_ORDER_ALL_LIST.put("9", "出版期数");
		REPORT_ORDER_ALL_LIST.put("10", "复本数");
		REPORT_ORDER_ALL_LIST.put("11", "价格");
		REPORT_ORDER_ALL_LIST.put("12", "原套价");
		REPORT_ORDER_ALL_LIST.put("13", "总价");
		REPORT_ORDER_ALL_LIST.put("14", "出版周期");
		REPORT_ORDER_ALL_LIST.put("15", "年价");
		REPORT_ORDER_ALL_LIST.put("16", "索书号");
		return REPORT_ORDER_ALL_LIST;
	}

	public static final String SERIES_REPORT_ORDER_NEW_EXPORT_NAME = "新订单报表";

	// public static final Map<String, String> REPORT_ORDER_NEW_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_NEW_LIST.put("-1", "序号");
	// REPORT_ORDER_NEW_LIST.put("0", "订购号");
	// REPORT_ORDER_NEW_LIST.put("1", "分类号");
	// REPORT_ORDER_NEW_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_NEW_LIST.put("3", "题名");
	// REPORT_ORDER_NEW_LIST.put("4", "出版社");
	// REPORT_ORDER_NEW_LIST.put("5", "出版周期");
	// REPORT_ORDER_NEW_LIST.put("6", "分馆代码");
	// REPORT_ORDER_NEW_LIST.put("7", "书商代码");
	// REPORT_ORDER_NEW_LIST.put("8", "预定年份");
	// REPORT_ORDER_NEW_LIST.put("9", "出版期数");
	// REPORT_ORDER_NEW_LIST.put("10", "价格");
	// REPORT_ORDER_NEW_LIST.put("11", "原套价");
	// REPORT_ORDER_NEW_LIST.put("12", "总价");
	// REPORT_ORDER_NEW_LIST.put("13", "索书号");
	// }

	public static final Map<String, String> getReportOrderNewList() {
		Map<String, String> REPORT_ORDER_NEW_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_NEW_LIST.put("-1", "序号");
		REPORT_ORDER_NEW_LIST.put("0", "订购号");
		REPORT_ORDER_NEW_LIST.put("1", "分类号");
		REPORT_ORDER_NEW_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_NEW_LIST.put("3", "题名");
		REPORT_ORDER_NEW_LIST.put("4", "出版社");
		REPORT_ORDER_NEW_LIST.put("5", "出版周期");
		REPORT_ORDER_NEW_LIST.put("6", "分馆代码");
		REPORT_ORDER_NEW_LIST.put("7", "书商代码");
		REPORT_ORDER_NEW_LIST.put("8", "预定年份");
		REPORT_ORDER_NEW_LIST.put("9", "出版期数");
		REPORT_ORDER_NEW_LIST.put("10", "价格");
		REPORT_ORDER_NEW_LIST.put("11", "原套价");
		REPORT_ORDER_NEW_LIST.put("12", "总价");
		REPORT_ORDER_NEW_LIST.put("13", "索书号");
		return REPORT_ORDER_NEW_LIST;
	}

	// public static final Map<String, String> SERIES_REPORT_ORDER_STOP_SORT_WAY
	// = new LinkedHashMap<String, String>();// 停订单报表排序方式
	//
	// static {
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderNo", "订购号");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.isbn", "ISBN");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.title", "题名");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("publisher", "出版社");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderTime", "订购时间");
	// }

	public static final Map<String, String> getSeriesReportOrderStopSortWay() {
		Map<String, String> SERIES_REPORT_ORDER_STOP_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderNo", "订购号");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.isbn", "ISBN");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.title", "题名");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("publisher", "出版社");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderTime", "订购时间");
		return SERIES_REPORT_ORDER_STOP_SORT_WAY;
	}

	public static final String SERIES_REPORT_ORDER_STOP_EXPORT_NAME = "停订单报表";

	// public static final Map<String, String> REPORT_ORDER_STOP_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_STOP_LIST.put("-1", "序号");
	// REPORT_ORDER_STOP_LIST.put("0", "订购号");
	// REPORT_ORDER_STOP_LIST.put("1", "分类号");
	// REPORT_ORDER_STOP_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_STOP_LIST.put("3", "题名");
	// REPORT_ORDER_STOP_LIST.put("4", "出版社");
	// REPORT_ORDER_STOP_LIST.put("5", "分馆代码");
	// REPORT_ORDER_STOP_LIST.put("6", "停订年份");
	// REPORT_ORDER_STOP_LIST.put("7", "停订时间");
	// REPORT_ORDER_STOP_LIST.put("8", "出版周期");
	// REPORT_ORDER_STOP_LIST.put("9", "索书号");
	// }

	public static final Map<String, String> getReportOrderStopList() {
		Map<String, String> REPORT_ORDER_STOP_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_STOP_LIST.put("-1", "序号");
		REPORT_ORDER_STOP_LIST.put("0", "订购号");
		REPORT_ORDER_STOP_LIST.put("1", "分类号");
		REPORT_ORDER_STOP_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_STOP_LIST.put("3", "题名");
		REPORT_ORDER_STOP_LIST.put("4", "出版社");
		REPORT_ORDER_STOP_LIST.put("5", "分馆代码");
		REPORT_ORDER_STOP_LIST.put("6", "停订年份");
		REPORT_ORDER_STOP_LIST.put("7", "停订时间");
		REPORT_ORDER_STOP_LIST.put("8", "出版周期");
		REPORT_ORDER_STOP_LIST.put("9", "索书号");
		return REPORT_ORDER_STOP_LIST;
	}

	public static final String SERIES_REPORT_ORDER_LOST_EXPORT_NAME = "漏订单报表";

	// public static final Map<String, String> REPORT_ORDER_LOST_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_LOST_LIST.put("-1", "序号");
	// REPORT_ORDER_LOST_LIST.put("0", "订购号");
	// REPORT_ORDER_LOST_LIST.put("1", "分类号");
	// REPORT_ORDER_LOST_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_LOST_LIST.put("3", "题名");
	// REPORT_ORDER_LOST_LIST.put("4", "出版社");
	// REPORT_ORDER_LOST_LIST.put("5", "出版周期");
	// REPORT_ORDER_LOST_LIST.put("6", "分馆代码");
	// REPORT_ORDER_LOST_LIST.put("7", "书商代码");
	// REPORT_ORDER_LOST_LIST.put("8", "预定年份");
	// REPORT_ORDER_LOST_LIST.put("9", "订购时间");
	// REPORT_ORDER_LOST_LIST.put("10", "出版期数");
	// REPORT_ORDER_LOST_LIST.put("11", "复本数");
	// REPORT_ORDER_LOST_LIST.put("12", "价格");
	// REPORT_ORDER_LOST_LIST.put("13", "原套价");
	// REPORT_ORDER_LOST_LIST.put("14", "总价");
	// REPORT_ORDER_LOST_LIST.put("15", "索书号");
	// }

	public static final Map<String, String> getReportOrderLostList() {
		Map<String, String> REPORT_ORDER_LOST_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_LOST_LIST.put("-1", "序号");
		REPORT_ORDER_LOST_LIST.put("0", "订购号");
		REPORT_ORDER_LOST_LIST.put("1", "分类号");
		REPORT_ORDER_LOST_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_LOST_LIST.put("3", "题名");
		REPORT_ORDER_LOST_LIST.put("4", "出版社");
		REPORT_ORDER_LOST_LIST.put("5", "出版周期");
		REPORT_ORDER_LOST_LIST.put("6", "分馆代码");
		REPORT_ORDER_LOST_LIST.put("7", "书商代码");
		REPORT_ORDER_LOST_LIST.put("8", "预定年份");
		REPORT_ORDER_LOST_LIST.put("9", "订购时间");
		REPORT_ORDER_LOST_LIST.put("10", "出版期数");
		REPORT_ORDER_LOST_LIST.put("11", "复本数");
		REPORT_ORDER_LOST_LIST.put("12", "价格");
		REPORT_ORDER_LOST_LIST.put("13", "原套价");
		REPORT_ORDER_LOST_LIST.put("14", "总价");
		REPORT_ORDER_LOST_LIST.put("15", "索书号");
		return REPORT_ORDER_LOST_LIST;
	}

	public static final String SERIES_REPORT_ACCEPT_ASK_NOT_IN_EXPORT_NAME = "未到馆期刊报表";

	public static final String SERIES_REPORT_ACCEPT_ASK_NOT_HERE_EXPORT_NAME = "未到齐期刊报表";

	// public static final Map<String, String> REPORT_ACCEPT_ASK_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_ACCEPT_ASK_LIST.put("-1", "序号");
	// REPORT_ACCEPT_ASK_LIST.put("0", "订购号");
	// REPORT_ACCEPT_ASK_LIST.put("1", "ISBN/ISSN");
	// REPORT_ACCEPT_ASK_LIST.put("2", "题名");
	// REPORT_ACCEPT_ASK_LIST.put("3", "出版社");
	// REPORT_ACCEPT_ASK_LIST.put("4", "出版周期");
	// REPORT_ACCEPT_ASK_LIST.put("5", "分馆代码");
	// REPORT_ACCEPT_ASK_LIST.put("6", "书商代码");
	// REPORT_ACCEPT_ASK_LIST.put("7", "预定年份");
	// REPORT_ACCEPT_ASK_LIST.put("8", "复本数");
	// REPORT_ACCEPT_ASK_LIST.put("9", "订购时间");
	// REPORT_ACCEPT_ASK_LIST.put("10", "未到册数");
	// REPORT_ACCEPT_ASK_LIST.put("11", "单价");
	// REPORT_ACCEPT_ASK_LIST.put("12", "卷期");
	// REPORT_ACCEPT_ASK_LIST.put("13", "预定");
	// }

	public static final Map<String, String> getReportAcceptAskList() {
		Map<String, String> REPORT_ACCEPT_ASK_LIST = new LinkedHashMap<String, String>();
		REPORT_ACCEPT_ASK_LIST.put("-1", "序号");
		REPORT_ACCEPT_ASK_LIST.put("0", "订购号");
		REPORT_ACCEPT_ASK_LIST.put("1", "ISBN/ISSN");
		REPORT_ACCEPT_ASK_LIST.put("2", "题名");
		REPORT_ACCEPT_ASK_LIST.put("3", "出版社");
		REPORT_ACCEPT_ASK_LIST.put("4", "出版周期");
		REPORT_ACCEPT_ASK_LIST.put("5", "分馆代码");
		REPORT_ACCEPT_ASK_LIST.put("6", "书商代码");
		REPORT_ACCEPT_ASK_LIST.put("7", "预定年份");
		REPORT_ACCEPT_ASK_LIST.put("8", "复本数");
		REPORT_ACCEPT_ASK_LIST.put("9", "订购时间");
		REPORT_ACCEPT_ASK_LIST.put("10", "未到册数");
		REPORT_ACCEPT_ASK_LIST.put("11", "单价");
		REPORT_ACCEPT_ASK_LIST.put("12", "卷期");
		REPORT_ACCEPT_ASK_LIST.put("13", "预定");
		return REPORT_ACCEPT_ASK_LIST;
	}

	public static final String SERIES_REPORT_ACCEPT_ARRIVE_EXPORT_NAME = "记到单报表";

	// public static final Map<String, String> REPORT_ACCEPT_ARRIVE_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_ACCEPT_ARRIVE_LIST.put("-1", "序号");
	// REPORT_ACCEPT_ARRIVE_LIST.put("0", "订购号");
	// REPORT_ACCEPT_ARRIVE_LIST.put("1", "记到人");
	// REPORT_ACCEPT_ARRIVE_LIST.put("2", "题名");
	// REPORT_ACCEPT_ARRIVE_LIST.put("3", "ISBN/ISSN");
	// REPORT_ACCEPT_ARRIVE_LIST.put("4", "期刊年");
	// REPORT_ACCEPT_ARRIVE_LIST.put("5", "卷册数量");
	// REPORT_ACCEPT_ARRIVE_LIST.put("6", "分类号");
	// REPORT_ACCEPT_ARRIVE_LIST.put("7", "馆藏地点");
	// REPORT_ACCEPT_ARRIVE_LIST.put("8", "卷期");
	// REPORT_ACCEPT_ARRIVE_LIST.put("9", "总期");
	// REPORT_ACCEPT_ARRIVE_LIST.put("10", "复本数");
	// REPORT_ACCEPT_ARRIVE_LIST.put("11", "分馆代码");
	// REPORT_ACCEPT_ARRIVE_LIST.put("12", "记到时间");
	// }

	public static final Map<String, String> getReportAcceptArriveList() {
		Map<String, String> REPORT_ACCEPT_ARRIVE_LIST = new LinkedHashMap<String, String>();
		REPORT_ACCEPT_ARRIVE_LIST.put("-1", "序号");
		REPORT_ACCEPT_ARRIVE_LIST.put("0", "订购号");
		REPORT_ACCEPT_ARRIVE_LIST.put("1", "记到人");
		REPORT_ACCEPT_ARRIVE_LIST.put("2", "题名");
		REPORT_ACCEPT_ARRIVE_LIST.put("3", "ISBN/ISSN");
		REPORT_ACCEPT_ARRIVE_LIST.put("4", "期刊年");
		REPORT_ACCEPT_ARRIVE_LIST.put("5", "卷册数量");
		REPORT_ACCEPT_ARRIVE_LIST.put("6", "分类号");
		REPORT_ACCEPT_ARRIVE_LIST.put("7", "馆藏地点");
		REPORT_ACCEPT_ARRIVE_LIST.put("8", "卷期");
		REPORT_ACCEPT_ARRIVE_LIST.put("9", "总期");
		REPORT_ACCEPT_ARRIVE_LIST.put("10", "复本数");
		REPORT_ACCEPT_ARRIVE_LIST.put("11", "分馆代码");
		REPORT_ACCEPT_ARRIVE_LIST.put("12", "记到时间");
		return REPORT_ACCEPT_ARRIVE_LIST;
	}

	// public static final Map<String, String> ALIGNMENTS = new
	// LinkedHashMap<String, String>();// 书标打印对齐方式
	// static {
	// ALIGNMENTS.put("left", "左");
	// ALIGNMENTS.put("center", "中");
	// ALIGNMENTS.put("right", "右");
	// }

	public static final Map<String, String> getAlignments() {
		Map<String, String> ALIGNMENTS = new LinkedHashMap<String, String>();
		ALIGNMENTS.put("left", "左");
		ALIGNMENTS.put("center", "中");
		ALIGNMENTS.put("right", "右");
		return ALIGNMENTS;
	}

	// public static final Map<String, String> FONT_TYPE = new
	// LinkedHashMap<String, String>();// 书标打印字体类型
	// static {
	// FONT_TYPE.put("SimSun", "宋体");
	// FONT_TYPE.put("SimHei", "黑体");
	// FONT_TYPE.put("KaiTi", "楷体");
	// FONT_TYPE.put("Arial", "Arial");
	// FONT_TYPE.put("Arial Black", "Arial Black");
	// FONT_TYPE.put("Arial Narrow", "Arial Narrow");
	// FONT_TYPE.put("Brush Script MT", "Brush Script MT");
	// FONT_TYPE.put("Century Gothic", "Century Gothic");
	// FONT_TYPE.put("Comic Sans MS", "Comic Sans MS");
	// FONT_TYPE.put("Courier", "Courier");
	// FONT_TYPE.put("Courier New", "Courier New");
	// FONT_TYPE.put("MS Sans Serif", "MS Sans Serif");
	// FONT_TYPE.put("Script", "Script");
	// FONT_TYPE.put("System", "System");
	// FONT_TYPE.put("Times New Roman", "Times New Roman");
	// FONT_TYPE.put("Verdana", "Verdana");
	// FONT_TYPE.put("Verdana2", "Verdana2");
	// FONT_TYPE.put("Wide Latin", "Wide Latin");
	// FONT_TYPE.put("Wingdings", "Wingdings");
	// }

	public static final Map<String, String> getFontType() {
		Map<String, String> FONT_TYPE = new LinkedHashMap<String, String>();
		FONT_TYPE.put("SimSun", "宋体");
		FONT_TYPE.put("SimHei", "黑体");
		FONT_TYPE.put("KaiTi", "楷体");
		FONT_TYPE.put("Arial", "Arial");
		FONT_TYPE.put("Arial Black", "Arial Black");
		FONT_TYPE.put("Arial Narrow", "Arial Narrow");
		FONT_TYPE.put("Brush Script MT", "Brush Script MT");
		FONT_TYPE.put("Century Gothic", "Century Gothic");
		FONT_TYPE.put("Comic Sans MS", "Comic Sans MS");
		FONT_TYPE.put("Courier", "Courier");
		FONT_TYPE.put("Courier New", "Courier New");
		FONT_TYPE.put("MS Sans Serif", "MS Sans Serif");
		FONT_TYPE.put("Script", "Script");
		FONT_TYPE.put("System", "System");
		FONT_TYPE.put("Times New Roman", "Times New Roman");
		FONT_TYPE.put("Verdana", "Verdana");
		FONT_TYPE.put("Verdana2", "Verdana2");
		FONT_TYPE.put("Wide Latin", "Wide Latin");
		FONT_TYPE.put("Wingdings", "Wingdings");
		return FONT_TYPE;
	}

	// public static final List<Integer> FONT_SIZE = new
	// LinkedList<Integer>();// 书标打印字体大小
	// static {
	// for (int i = 1; i <= 30; i++)
	// FONT_SIZE.add(i);
	// }

	public static final List<Integer> getFontSize() {
		List<Integer> FONT_SIZE = new LinkedList<Integer>();
		for (int i = 1; i <= 30; i++)
			FONT_SIZE.add(i);
		return FONT_SIZE;
	}

	// public static final Map<String, String> FONT_BOLD = new
	// LinkedHashMap<String, String>();// 书标打印字体加粗
	// static {
	// FONT_BOLD.put("normal", "正常");
	// FONT_BOLD.put("bold", "加粗");
	// }

	public static final Map<String, String> getFontBold() {
		Map<String, String> FONT_BOLD = new LinkedHashMap<String, String>();
		FONT_BOLD.put("normal", "正常");
		FONT_BOLD.put("bold", "加粗");
		return FONT_BOLD;
	}

	// public static final Map<String, String> SERIES_REPORT_BIND_ALL_SORT_WAY =
	// new LinkedHashMap<String, String>();// 装订单报表排序方式
	//
	// static {
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.orderNo", "订购号");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.title", "题名");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.publisher", "出版社");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("bookSellerId", "书商");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("batchNo", "装订条码");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("bindDate", "装订时间");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("volInfo", "卷册信息");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("callNo", "索书号");
	// }

	public static final Map<String, String> getSeriesReportAllSortWay() {
		Map<String, String> SERIES_REPORT_BIND_ALL_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.orderNo", "订购号");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.title", "题名");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.publisher", "出版社");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("bookSellerId", "书商");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("batchNo", "装订条码");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("bindDate", "装订时间");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("volInfo", "卷册信息");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("callNo", "索书号");
		return SERIES_REPORT_BIND_ALL_SORT_WAY;
	}

	public static final String SERIES_REPORT_BIND_ALL_EXPORT_NAME = "装订单报表";

	// public static final Map<String, String> REPORT_BINA_ALL_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_BINA_ALL_LIST.put("-1", "序号");
	// REPORT_BINA_ALL_LIST.put("0", "条码号");
	// REPORT_BINA_ALL_LIST.put("1", "ISBN/ISSN");
	// REPORT_BINA_ALL_LIST.put("2", "分类号");
	// REPORT_BINA_ALL_LIST.put("3", "题名");
	// REPORT_BINA_ALL_LIST.put("4", "订购号");
	// REPORT_BINA_ALL_LIST.put("5", "卷信息");
	// REPORT_BINA_ALL_LIST.put("6", "分馆代码");
	// REPORT_BINA_ALL_LIST.put("7", "装帧形式");
	// REPORT_BINA_ALL_LIST.put("8", "装订人");
	// REPORT_BINA_ALL_LIST.put("9", "装订时间");
	// REPORT_BINA_ALL_LIST.put("10", "装订状态");
	// REPORT_BINA_ALL_LIST.put("11", "馆藏地点");
	// REPORT_BINA_ALL_LIST.put("12", "价格");
	// REPORT_BINA_ALL_LIST.put("13", "出版频率");
	// }

	public static final Map<String, String> getReportBindAllList() {
		Map<String, String> REPORT_BINA_ALL_LIST = new LinkedHashMap<String, String>();
		REPORT_BINA_ALL_LIST.put("-1", "序号");
		REPORT_BINA_ALL_LIST.put("0", "条码号");
		REPORT_BINA_ALL_LIST.put("1", "ISBN/ISSN");
		REPORT_BINA_ALL_LIST.put("2", "分类号");
		REPORT_BINA_ALL_LIST.put("3", "题名");
		REPORT_BINA_ALL_LIST.put("4", "订购号");
		REPORT_BINA_ALL_LIST.put("5", "卷信息");
		REPORT_BINA_ALL_LIST.put("6", "分馆代码");
		REPORT_BINA_ALL_LIST.put("7", "装帧形式");
		REPORT_BINA_ALL_LIST.put("8", "装订人");
		REPORT_BINA_ALL_LIST.put("9", "装订时间");
		REPORT_BINA_ALL_LIST.put("10", "装订状态");
		REPORT_BINA_ALL_LIST.put("11", "馆藏地点");
		REPORT_BINA_ALL_LIST.put("12", "价格");
		REPORT_BINA_ALL_LIST.put("13", "出版频率");
		return REPORT_BINA_ALL_LIST;
	}

	public static final String SERIES_STATISTICS_ORDER_ALL_EXPORT_NAME = "订购统计报表";

	public static final String SERIES_STAISTICS_ORDER_NEW_EXPORT_NAME = "新订统计报表";

	public static final String SERIES_STAISTICS_ORDER_STOP_EXPORT_NAME = "停订统计报表";

	public static final String SERIES_STATISTICS_ORDER_LOST_EXPORT_NAME = "漏订统计报表";

	public static final String SERIES_STATISTICS_ORDER_ARRIVE_EXPORT_NAME = "记到统计报表";

	public static final String SERIES_STATISTICS_ORDER_BIND_ALL_NAME = "装订统计报表";

	// public static final Map<String, String> SERIES_STATISTICS_ORDER_ALL_LIST
	// = new LinkedHashMap<String, String>();
	//
	// static {
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("-1", "序号");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("0", "分类号");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("1", "总数");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("2", "册数");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("3", "总价");
	// }

	public static final Map<String, String> getSeriesStatisticsOrderAllList() {
		Map<String, String> SERIES_STATISTICS_ORDER_ALL_LIST = new LinkedHashMap<String, String>();
		SERIES_STATISTICS_ORDER_ALL_LIST.put("-1", "序号");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("0", "分类号");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("1", "总数");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("2", "册数");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("3", "总价");
		return SERIES_STATISTICS_ORDER_ALL_LIST;
	}

	public static final String RENEW_SUCCESS = "renew_success"; // 续借成功

	public static final String LEND_DEAL_MAX = "lend_deal_max"; // 续借次数已到

	public static final String LOSE_PENALTY = "lose_penalty"; // 丢书罚款

	public static final String NO_LOSE = "no_lost";// 无罚款单

	public static final String BROKEN_PENALTY = "broken_penalty"; // 污损罚款

	public static final String LEND_PENALTY = "lend_penalty"; // 超期罚款

	public static final String WARN_BATCH_NOTREGIST = "regist_not_edit";// 该状态不能修改

	public static final String WARN_BATCH_EXISR_BIBLIOTEMP = "exist_biblio_temp";// 批次里已存在期刊

	public static final String WARN_BATCH_NOT_FINISH = "warn_batch_not_finish";// 完成状态不能清空

	public static final Integer FINES_OVERDUE = 3; // 罚单类型（超期）

	public static final Integer FINES_BROKEN = 4; // 罚单类型（污损）

	public static final Integer FINES_LOST = 5; // 罚单类型（丢失）

	public static final Integer PAY_TYPE_UNTREATED = 4; // 付款方式（未处理）

	public static final Integer PAY_TYPE_CASH = 1; // 付款方式（现金）

	public static final Integer PAY_TYPE_ONECARD = 2;// 付款方式（一卡通）

	public static final Integer PAY_TYPE_CANCEL = 3;// 付款方式（取消罚款）

	public static final Integer PAY_STATUS_ARREARAGE = 1;// 付款类型（未付款）

	public static final Integer PAY_STATUS_MADE = 2;// 付款类型（已付款）

	public static final Integer PAY_STATUS_REFUND = 3;// 付款类型（退款）

	public static final String CAPTCHA_CAPTCHACODE = "/captcha/captchaCode";// 获取验证码的路径

	public static final String MANAGER_OUT = "/manegerOut";// 获取验证码的路径

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key(验证码)

	public static final Integer LOGIN_FAIL_MAX_TIME = 3;// 登入失败的次数

	public static final String LOGIN_ERROR_INFO_CAPTCHA = "验证码错误!";// 验证码错误

	public static final String SERIES_BATCH_SEND_SUCCESS = "series_batch_send_success";// 批量交送成功

	public static final Integer INIT_READER_UPLOAD_STARTROWNUM = 1; // 默认导入开始列数

	public static final String INIT_PATH_SERIESCYCLE = "InitSeriesCycle.xml";

	public static final String INIT_DATA_SERIESCYCLE = "/SeriesCycles/SeriesCycle";// 初始化数据的时候
																					// 出版周期的
																					// xml配置

	public static final String INIT_PATH_SERIESCURRENCY = "InitSeriesCurrency.xml";

	public static final String INIT_DATA_SERIESCURRENCY = "/SeriesCurrencys/SeriesCurrency";// 初始化数据的时候
																							// xml配置
																							// 货币管理

	public static final String INIT_PATH_ROLE = "InitRole.xml";

	public static final String INIT_DATA_ROLE = "/roles/role";

	public static final Integer SEARCH_ABLE = 1; // 可用检索标识

	public static final int INIT_SERIES_TYPE = 1;// 期刊 类别的初始化值

	public static final String WARN_RELATED_DATA = "warn_related_data";// 有关联数据,不能删除

	public static final Integer SEARCH_ENABLE = 2; // 不可用检索标识

	public static final Integer SEARCHMODE_FUZZY = 1; // 模糊查询

	public static final Integer SEARCHMODE_PRECISE = 2; // 精确查询

	public static final String COLLECTIONPLACE_NOT_NULL = "collectionPlace_not_null"; // 馆藏地不能为空

	public static final String EXIST_BARCODE = "exist_barcode";// 已经存在的条码

	public static final String SUCCESS_BARCODE = "success_barcode";// 成功入馆藏的条码

	public static final String BARCODE_SHOW_TOKEN = "show_token";// 交送页面刷新
																	// 防止提交token

	public static final String READERLENDRULE_EXIST = "readerlendrule_exist"; // 借阅规则已存在，无法新建，请修改对应的借阅规则

	public static final Integer NOT_IN_COLLECTION = 1; // 不在馆标识

	public static final String WARN_BOOKLENDDETAIL_NOT_NULL = "warn_booklenddetail_not_null"; // 文献借阅清单,当输入条码为空时的提示。

	public static final String GZ_SERVER = "z39.91marc.cn";// 广州z3950服务器地址

	public static final String WARN_LENDDETAIL_NOT_NULL = "warn_lenddetail_not_null";// 读者明细清单,当输入条码为空时的提示。

	public static final String WARN_LENDDETAIL_NOT_EXIST = "warn_lenddetail_not_exist"; // 读者明细清单,当输入条码不存在时的提示。

	public static final String WARN_BOOKLENDDETAIL_NOT_EXIST = "warn_booklenddetail_not_exist"; // 文献借阅清单,当输入条码不存在时的提示。

	// public static final List<String> CALLNO_FILTER_LIST = new
	// LinkedList<String>();// 索书号过滤列表
	//
	// static {
	// // 著、等著、原著、原作、 编 、主编 、编写、编著、选编、改编、 编译、 译、译注、注译、绘图、、撰、撰文、图、评注、讲述
	// CALLNO_FILTER_LIST.add("等著");
	// CALLNO_FILTER_LIST.add("原著");
	// CALLNO_FILTER_LIST.add("原作");
	// CALLNO_FILTER_LIST.add("主编");
	// CALLNO_FILTER_LIST.add("编写");
	// CALLNO_FILTER_LIST.add("编著");
	// CALLNO_FILTER_LIST.add("选编");
	// CALLNO_FILTER_LIST.add("改编");
	// CALLNO_FILTER_LIST.add("编译");
	// CALLNO_FILTER_LIST.add("译注");
	// CALLNO_FILTER_LIST.add("注译");
	// CALLNO_FILTER_LIST.add("绘图");
	// CALLNO_FILTER_LIST.add("撰文");
	// CALLNO_FILTER_LIST.add("评注");
	// CALLNO_FILTER_LIST.add("讲述");
	// CALLNO_FILTER_LIST.add("编");
	// CALLNO_FILTER_LIST.add("著");
	// CALLNO_FILTER_LIST.add("译");
	// CALLNO_FILTER_LIST.add("图");
	// CALLNO_FILTER_LIST.add("撰");
	// }

	public static final List<String> getCallNoFilterList() {
		List<String> CALLNO_FILTER_LIST = new LinkedList<String>();
		CALLNO_FILTER_LIST.add("等著");
		CALLNO_FILTER_LIST.add("原著");
		CALLNO_FILTER_LIST.add("原作");
		CALLNO_FILTER_LIST.add("主编");
		CALLNO_FILTER_LIST.add("编写");
		CALLNO_FILTER_LIST.add("编著");
		CALLNO_FILTER_LIST.add("选编");
		CALLNO_FILTER_LIST.add("改编");
		CALLNO_FILTER_LIST.add("编译");
		CALLNO_FILTER_LIST.add("译注");
		CALLNO_FILTER_LIST.add("注译");
		CALLNO_FILTER_LIST.add("绘图");
		CALLNO_FILTER_LIST.add("撰文");
		CALLNO_FILTER_LIST.add("评注");
		CALLNO_FILTER_LIST.add("讲述");
		CALLNO_FILTER_LIST.add("编");
		CALLNO_FILTER_LIST.add("著");
		CALLNO_FILTER_LIST.add("译");
		CALLNO_FILTER_LIST.add("图");
		CALLNO_FILTER_LIST.add("撰");
		return CALLNO_FILTER_LIST;
	}

	// public static final List<String> CALLNO_SIGN_LIST = new
	// LinkedList<String>();// 索书号符号过滤
	// static {
	// CALLNO_SIGN_LIST.add("，");
	// CALLNO_SIGN_LIST.add(",");
	// CALLNO_SIGN_LIST.add("、");
	// CALLNO_SIGN_LIST.add("/");
	// CALLNO_SIGN_LIST.add(" ");
	// }

	public static final List<String> getCallNoSignList() {
		List<String> CALLNO_SIGN_LIST = new LinkedList<String>();
		CALLNO_SIGN_LIST.add("，");
		CALLNO_SIGN_LIST.add(",");
		CALLNO_SIGN_LIST.add("、");
		CALLNO_SIGN_LIST.add("/");
		CALLNO_SIGN_LIST.add(" ");
		return CALLNO_SIGN_LIST;
	}

	// public static final Map<String, String> BOOKMARKSUBSTR = new
	// HashMap<String, String>();
	// static {
	// BOOKMARKSUBSTR.put("", "取全部");
	// BOOKMARKSUBSTR.put("before", "分隔符前");
	// BOOKMARKSUBSTR.put("after", "分隔符后");
	// }

	public static final Map<String, String> getBookMarkSubStr() {
		Map<String, String> BOOKMARKSUBSTR = new HashMap<String, String>();
		BOOKMARKSUBSTR.put("", "取全部");
		BOOKMARKSUBSTR.put("before", "分隔符前");
		BOOKMARKSUBSTR.put("after", "分隔符后");
		return BOOKMARKSUBSTR;
	}

	public static final String BOOKMARKSUBSTRBEFORE = "before";

	public static final String BOOKMARKSUBSTRAFTER = "after";

	public static final Integer CATALOGBOOKMARK = 1;// 书目书标打印

	public static final Integer SERIESBOOKMARK = 2;// 期刊书标打印

	public static final Integer BINDBOOKMARK = 3;// 装订书标打印

	// public static final List<String> ISBN_FILTER_LIST = new
	// LinkedList<String>();// isbn号自动分割提取内容
	// static {
	// ISBN_FILTER_LIST.add("9900000-9999999");
	// ISBN_FILTER_LIST.add("900000-989999");
	// ISBN_FILTER_LIST.add("80000-89999");
	// ISBN_FILTER_LIST.add("5000-7999");
	// ISBN_FILTER_LIST.add("100-499");
	// ISBN_FILTER_LIST.add("00-09");
	// }

	public static final List<String> getIsbnFilterList() {
		List<String> ISBN_FILTER_LIST = new LinkedList<String>();
		ISBN_FILTER_LIST.add("9900000-9999999");
		ISBN_FILTER_LIST.add("900000-989999");
		ISBN_FILTER_LIST.add("80000-89999");
		ISBN_FILTER_LIST.add("5000-7999");
		ISBN_FILTER_LIST.add("100-499");
		ISBN_FILTER_LIST.add("00-09");
		return ISBN_FILTER_LIST;
	}

	// public static final List<String> DESK_RESOURCES = new
	// LinkedList<String>();
	// static {
	// DESK_RESOURCES.add("图书验收");
	// DESK_RESOURCES.add("书目维护");
	// DESK_RESOURCES.add("馆藏状态处理");
	// DESK_RESOURCES.add("馆藏变更");
	// DESK_RESOURCES.add("借书");
	// DESK_RESOURCES.add("还书");
	// DESK_RESOURCES.add("读者信息管理");
	// DESK_RESOURCES.add("脱机借还程序");
	// DESK_RESOURCES.add("脱机流通接收");
	// }

	public static final List<String> getDeskResource() {
		List<String> DESK_RESOURCES = new LinkedList<String>();
		DESK_RESOURCES.add("书目维护");
		DESK_RESOURCES.add("图书验收");
		DESK_RESOURCES.add("借书");
		DESK_RESOURCES.add("还书");
		DESK_RESOURCES.add("脱机借还程序");
		DESK_RESOURCES.add("脱机流通接收");
		DESK_RESOURCES.add("读者信息管理");
		DESK_RESOURCES.add("馆藏状态处理");
		DESK_RESOURCES.add("馆藏变更");
		DESK_RESOURCES.add("阅览登入");
		return DESK_RESOURCES;
	}

	public static final String MAIN_PAGE_LINK_NAME = "采编管理";// 系统主页链接的一级资源名

	public static final String OFFLINECIRCUL = "/offlineCircul/OfflineCircul.zip";// 脱机文件下载的路径

	public static final String OPERATIONTYPER = "r";// 操作类型r 还书

	public static final String OPERATIONTYPEL = "l";// 操作类型l 借书

	public static final String DATE_NOT_NULL = "date_not_null";// 日期不能为空

	public static final String SEARCH_PARAMETER_NOT_EXIST = "search_parameter_not_exist"; // 搜索条件不存在

	public static final Integer INIT_BOOKNUM = 10; // 初始化文献借阅排行榜统计册数

	public static final Integer CARD_MANAGER = 44; // 证管理状态处理

	public static final String READER_IS_NOT_SINLGE = "reader_is_not_sinlge"; // 请选择一个读者

	public static final String EXEC_SUCCESS = "exec_success"; // 处理成功

	// public static final List<String> IP_NO_LIMIT_LOCATION = new
	// ArrayList<String>();// 可以登入的ip地区
	// static {
	// IP_NO_LIMIT_LOCATION.add("温州市");
	//
	// }

	public static final List<String> getIpNoLimitLocation() {
		List<String> IP_NO_LIMIT_LOCATION = new ArrayList<String>();
		IP_NO_LIMIT_LOCATION.add("温州市");
		return IP_NO_LIMIT_LOCATION;
	}

	// public static final List<String> IP_NO_LIMIT = new ArrayList<String>();//
	// 不用进行判断的ip
	// static {
	// IP_NO_LIMIT.add("保留地址用于本地回送");
	// IP_NO_LIMIT.add("局域网");
	// }

	public static final List<String> getIpNoLimit() {
		List<String> IP_NO_LIMIT = new ArrayList<String>();
		IP_NO_LIMIT.add("保留地址用于本地回送");
		IP_NO_LIMIT.add("局域网");
		return IP_NO_LIMIT;
	}

	// public static final List<String> IP_LIMIT_TYPE = new
	// ArrayList<String>();// 电信能够登入
	// static {
	// IP_LIMIT_TYPE.add("电信");
	// IP_LIMIT_TYPE.add("移动");
	// }

	public static final List<String> getIpLimitType() {
		List<String> IP_LIMIT_TYPE = new ArrayList<String>();
		IP_LIMIT_TYPE.add("电信");
		IP_LIMIT_TYPE.add("移动");
		return IP_LIMIT_TYPE;
	}

	public static final String QQWRY_DAT_PATH = "QQWRY";// ip数据库文件

	public static final String QQWARY_DAT_NAME = "qqwry.dat";// 数据库文件名称

	public static final String ERROR_IP_LIMIT = "IP限制";// ip收限制

	public static final String ERROR_ACTIVE_CODE_PAST_DUE = "激活码已经过期";

	public static final String READER_LEND_RULE_NOT_EXIST = "reader_lend_rule_not_exist"; // 借阅规则不存在，请先设置

	public static final Integer COLLECTION_DELETED = 2; // 馆藏误删状态

	public static final String COLLECTION_DELETED_WARN = "collection_deleted_warn"; // 误删借阅提示

	public static final String READER_ID = "reader_id"; // 读者Id session

	public static final String OVERDUE_SUCCESS = "overdue_success"; // 催还成功

	public static final String OVERDUE_ALL_SUCCESS = "overdue_all_success"; // 催还所有清单成功

	// public static final Map<Integer, String> SERIESACCEPTSTATUS = new
	// HashMap<Integer, String>();// 记到状态转化
	// static {
	// SERIESACCEPTSTATUS.put(2, "color-001");
	// SERIESACCEPTSTATUS.put(3, "color-002");
	// SERIESACCEPTSTATUS.put(4, "color-003");
	// SERIESACCEPTSTATUS.put(5, "color-004");
	// SERIESACCEPTSTATUS.put(6, "color-005");
	// SERIESACCEPTSTATUS.put(7, "color-006");
	// SERIESACCEPTSTATUS.put(8, "color-007");
	// SERIESACCEPTSTATUS.put(9, "color-008");
	// SERIESACCEPTSTATUS.put(10, "color-009");
	// SERIESACCEPTSTATUS.put(1, "color-default");
	//
	// }

	public static final Map<Integer, String> getSeriesAcceptStatus() {
		Map<Integer, String> SERIESACCEPTSTATUS = new HashMap<Integer, String>();
		SERIESACCEPTSTATUS.put(2, "color-001");
		SERIESACCEPTSTATUS.put(3, "color-002");
		SERIESACCEPTSTATUS.put(4, "color-003");
		SERIESACCEPTSTATUS.put(5, "color-004");
		SERIESACCEPTSTATUS.put(6, "color-005");
		SERIESACCEPTSTATUS.put(7, "color-006");
		SERIESACCEPTSTATUS.put(8, "color-007");
		SERIESACCEPTSTATUS.put(9, "color-008");
		SERIESACCEPTSTATUS.put(10, "color-009");
		SERIESACCEPTSTATUS.put(1, "color-default");
		return SERIESACCEPTSTATUS;
	}

	public static final String SYS_MASSAGE_MIDDLE = ">应还日期为"; // 读者信息发送中

	public static final String SYS_MASSAGE_FOOT = "，请及时归还到图书馆！"; // 读者信息发送脚

	public static final Integer SYS_MESSAGE_STATUS_ENEXEC = 1;// 读者消息处理状态未读

	public static final Integer SYS_MESSAGE_STATUS_EXEC = 2;// 读者消息处理状态已读

	public static final Integer SYS_MESSAGE_STATUS = 45;// 读者消息处理状态

	public static final String SYS_MASSAGE_TITLE = "图书馆催还通知！";// 读者消息管理默认标题

	public static final String LEND_OVER_DUE = "lend_over_due";// 读者有图书过期，请先还回

	public static final String NO_TYPE_FOR_SEARCH = "no_type_for_search";// 符合该条件的记录不存在

	public static final Double READERSTAT_INIT_ARREARAGE = (double) 0;// 初始化读者账户余额

	public static final Integer FINES_EXECED = 2; // 已处理

	public static final Integer FINES_UNEXECED = 1; // 未处理

	public static final Integer FEE_TYPE_KEY = 46; // 罚款模式键值

	public static final Integer DEAL_STATUS_KEY = 47; // 处理模式键值

	public static final String PAY_FOR_IC = "pay_for_ic"; // IC付款成功

	public static final String PAY_FOR_LATER = "pay_for_later"; // 以后付款成功

	public static final String PAY_FOR_CASH = "pay_for_cash"; // 现金付款成功

	public static final String PAY_FOR_CANCEL = "pay_for_cancel"; // 取消付款成功

	public static final String LOSE_FIND = "lose_find"; // 丢书找回成功

	public static final String READERSTAT_ARREARAGE_OUT = "readerstat_arrearage_out"; // 读者有罚金未交，请先交纳罚金

	public static final Integer FEE_TYPE_OVERDUE = 3; // 读者流通图书超期

	public static final Integer FEE_TYPE_BROKEN = 4; // 读者流通图书污损

	public static final Integer FEE_TYPE_LOSE = 5; // 读者流通图书丢失

	public static final Integer DEAL_STATUS_FIND_BACK = 3; // 丢书找回

	public static final String ONE_RECORD_LIMIT = "one_record_limit"; // 请选择至少一条记录

	// public static final Map<String, String> readerTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// readerTitle.put("0", "序号");
	// readerTitle.put("1", "组织代码");
	// readerTitle.put("2", "读者证号");
	// readerTitle.put("3", "姓名");
	// readerTitle.put("4", "性别");
	// readerTitle.put("5", "教师");
	// readerTitle.put("6", "状态");
	// readerTitle.put("7", "启用时间");
	// readerTitle.put("8", "终止时间");
	// }

	public static final Map<String, String> getReaderTitle() {
		Map<String, String> readerTitle = new LinkedHashMap<String, String>();
		readerTitle.put("0", "序号");
		readerTitle.put("1", "组织代码");
		readerTitle.put("2", "读者证号");
		readerTitle.put("3", "姓名");
		readerTitle.put("4", "性别");
		readerTitle.put("5", "教师");
		readerTitle.put("6", "状态");
		readerTitle.put("7", "启用时间");
		readerTitle.put("8", "终止时间");
		return readerTitle;
	}

	public static final String READER_EXPORT_NAME = "读者清单";// 读者清单导出名称

	public static final Map<String, String> circulateDetailTitle = new LinkedHashMap<String, String>();
	static {
		circulateDetailTitle.put("0", "序号");
		circulateDetailTitle.put("1", "姓名");
		circulateDetailTitle.put("2", "读者证号");
		circulateDetailTitle.put("3", "题名");
		circulateDetailTitle.put("4", "条码号");
		circulateDetailTitle.put("5", "馆藏地点");
		circulateDetailTitle.put("6", "流通类型");
		circulateDetailTitle.put("7", "索书号");
		circulateDetailTitle.put("8", "卷册信息");
		circulateDetailTitle.put("9", "单价");
		circulateDetailTitle.put("10", "借书日期");
		circulateDetailTitle.put("11", "还书日期");
		circulateDetailTitle.put("12", "处理日期");
		circulateDetailTitle.put("13", "状态");
		circulateDetailTitle.put("14", "续借次数");
	}

	public static final String CIRCULATE_DETAIL_EXPORT_NAME = "读者历史流通清单";// 读者历史流通清单导出名称

	public static final String BOOK_CIRCULATE_DETAIL_EXPORT_NAME = "文献历史借阅查询";// 文献历史借阅查询清单导出名称

	// public static final Map<String, String> readerLendRankingTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// readerLendRankingTitle.put("0", "序号");
	// readerLendRankingTitle.put("1", "姓名");
	// readerLendRankingTitle.put("2", "读者证号");
	// readerLendRankingTitle.put("3", "所属组织");
	// readerLendRankingTitle.put("4", "读者类型");
	// readerLendRankingTitle.put("5", "借阅次数");
	// }

	public static final Map<String, String> getReaderRankinhgTitle() {
		Map<String, String> readerLendRankingTitle = new LinkedHashMap<String, String>();
		readerLendRankingTitle.put("0", "序号");
		readerLendRankingTitle.put("1", "姓名");
		readerLendRankingTitle.put("2", "读者证号");
		readerLendRankingTitle.put("3", "所属组织");
		readerLendRankingTitle.put("4", "读者类型");
		readerLendRankingTitle.put("5", "借阅次数");
		return readerLendRankingTitle;
	}

	public static final String READER_LEND_RANKING_EXPORT_NAME = "读者借阅排行榜";// 读者借阅排行榜清单导出名称

	// public static final Map<String, String> bookCirculateRankingTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// bookCirculateRankingTitle.put("0", "序号");
	// bookCirculateRankingTitle.put("1", "题名");
	// bookCirculateRankingTitle.put("2", "作者");
	// bookCirculateRankingTitle.put("3", "分类号");
	// bookCirculateRankingTitle.put("4", "出版时间");
	// bookCirculateRankingTitle.put("5", "借阅次数");
	// }

	public static final Map<String, String> getBookCirculateRanking() {
		Map<String, String> bookCirculateRankingTitle = new LinkedHashMap<String, String>();
		bookCirculateRankingTitle.put("0", "序号");
		bookCirculateRankingTitle.put("1", "题名");
		bookCirculateRankingTitle.put("2", "作者");
		bookCirculateRankingTitle.put("3", "分类号");
		bookCirculateRankingTitle.put("4", "出版时间");
		bookCirculateRankingTitle.put("5", "借阅次数");
		return bookCirculateRankingTitle;
	}

	public static final String BOOK_CIRCULATE_RANKING_EXPORT_NAME = "文献借阅排行榜";// 读者借阅排行榜清单导出名称

	public static final String WARN_SYSDATA = "warn_sysDate";// 系统参数，不允许操作

	public static final String READER_TYPE_EXIST = "reader_type_exist";// 读者流通类型代码不能重复

	public static final String SAVA_SUCCESS = "sava_success";// 数据保存成功

	public static final String SCHOOL_DEPT_EXIST = "school_dept_exist";// 组织代码不能重复

	public static final String READER_EXIST = "reader_exist";// 读者条码不能重复

	public static final String READER_PECCANCY_OUT = "reader_peccancy_out";// 不能超过最大违规次数

	public static final String WARN_COLLECTIONPLACE_EXIST = "warn_collectionplace_exist";// 馆藏地存在提示

	// public static final Map<String, String> LOGIC = new HashMap<String,
	// String>();// webopac页面的逻辑关系
	// static {
	// LOGIC.put("与", "and");
	// LOGIC.put("或", "or");
	// }

	public static final Map<String, String> getLogic() {
		Map<String, String> LOGIC = new HashMap<String, String>();
		LOGIC.put("与", "and");
		LOGIC.put("或", "or");
		return LOGIC;
	}

	// public static final Map<String, String> WO_QUERY_FIELD = new
	// HashMap<String, String>();// webopac查询的字段
	// static {
	// WO_QUERY_FIELD.put("题名", "title");
	// WO_QUERY_FIELD.put("ISBN/ISSN", "isbn");
	// WO_QUERY_FIELD.put("著者", "author");
	// WO_QUERY_FIELD.put("分类号", "class_no");
	// WO_QUERY_FIELD.put("出版社", "publisher");
	// }

	public static final Map<String, String> getWoQueryField() {
		Map<String, String> WO_QUERY_FIELD = new HashMap<String, String>();
		WO_QUERY_FIELD.put("题名", "title");
		WO_QUERY_FIELD.put("ISBN/ISSN", "isbn");
		WO_QUERY_FIELD.put("著者", "author");
		WO_QUERY_FIELD.put("分类号", "class_no");
		WO_QUERY_FIELD.put("出版社", "publisher");
		return WO_QUERY_FIELD;
	}

	// public static final Map<String, String> WO_SORT_FIELD = new
	// HashMap<String, String>();// webopac排序字段
	// static {
	// WO_SORT_FIELD.put("--默认--", "id");
	// WO_SORT_FIELD.put("作者", "author");
	// WO_SORT_FIELD.put("出版时间", "publisher");
	// }

	public static final Map<String, String> getWoSortField() {
		Map<String, String> WO_SORT_FIELD = new HashMap<String, String>();
		WO_SORT_FIELD.put("--默认--", "id");
		WO_SORT_FIELD.put("作者", "author");
		WO_SORT_FIELD.put("出版时间", "publisher");
		return WO_SORT_FIELD;
	}

	public static final String WARN_SYSROLE_EXIST = "warn_sysrole_exist";// 角色存在提示

	public static final String WARN_CURRENT_VERSION = "warn_current_version";// 当前版次不给于删除

	public static final Integer ONE_CARD_NAME = 48; // 一卡通厂家列表

	public static final Integer ZYTK_VERSION = 49; // 正元一卡通版本号

	// public static final List<String> ZYTK_VERSION_RESOURCES = new
	// ArrayList<String>();// 正元智慧一卡通版本号
	// static {
	// ZYTK_VERSION_RESOURCES.add("2.2");
	// ZYTK_VERSION_RESOURCES.add("3.2");
	// }

	public static final List<String> getZytkVersionResource() {
		List<String> ZYTK_VERSION_RESOURCES = new ArrayList<String>();
		ZYTK_VERSION_RESOURCES.add("2.2");
		ZYTK_VERSION_RESOURCES.add("3.2");
		return ZYTK_VERSION_RESOURCES;
	}

	// public static final List<String> SCHOOL_CARD_RESOURCES = new
	// ArrayList<String>();// 校讯通版本号
	// static {
	// SCHOOL_CARD_RESOURCES.add("1.0");
	// SCHOOL_CARD_RESOURCES.add("2.0");
	// }

	public static final List<String> getSchoolCardResource() {
		List<String> SCHOOL_CARD_RESOURCES = new ArrayList<String>();
		SCHOOL_CARD_RESOURCES.add("1.0");
		SCHOOL_CARD_RESOURCES.add("2.0");
		return SCHOOL_CARD_RESOURCES;
	}

	// public static final List<String> RESOURCE_OPERRATE_LIST = new
	// LinkedList<String>();
	// static {
	// RESOURCE_OPERRATE_LIST.add("还书");
	// RESOURCE_OPERRATE_LIST.add("丢书");
	// RESOURCE_OPERRATE_LIST.add("污损");
	// RESOURCE_OPERRATE_LIST.add("欠款读者");
	// RESOURCE_OPERRATE_LIST.add("操作员管理");
	// RESOURCE_OPERRATE_LIST.add("角色管理");
	// RESOURCE_OPERRATE_LIST.add("学校公告");
	// }

	public static final List<String> getResourceOperateList() {
		List<String> RESOURCE_OPERRATE_LIST = new LinkedList<String>();
		RESOURCE_OPERRATE_LIST.add("还书");
		RESOURCE_OPERRATE_LIST.add("丢书");
		RESOURCE_OPERRATE_LIST.add("污损");
		RESOURCE_OPERRATE_LIST.add("欠款读者");
		// RESOURCE_OPERRATE_LIST.add("操作员管理");
		// RESOURCE_OPERRATE_LIST.add("角色管理");
		// RESOURCE_OPERRATE_LIST.add("学校公告");
		return RESOURCE_OPERRATE_LIST;
	}

	public static final int CALLNO_TYPE = 217;// 索书号类型数据字典值

	public static final int PINYIN = 1;// 索书号拼音生成方式

	public static final int FOUR_CORNER_NUMBER = 2;// 索书号四角号码生成方式

	public static final int SEQUENCE = 3;// 索书号种次号生成方式

	public static final int FOUR_CORNER_NUMBER_NAME_TYPE = 218;// 四角号码对应姓名类型数据字典值

	public static final int SINGLE_FAMILY_SINGLE_NAME = 1;// 单姓单名

	public static final int SINGLE_FAMILY_DOUBLE_NAME = 2;// 单姓双名

	public static final int DOUBLE_FAMILY_SINGLE_NAME = 3;// 双姓单名

	public static final int DOUBLE_FAMILY_DOUBLE_NAME = 4;// 双姓双名

	public static final int SUPER_FAMILY_SUPER_NAME = 5;// 超级姓名(4字以上)

	public static final String SMS_PRICE_PATH = "SmsPrice.xml";

	public static final String SMS_PRICE_DATA = "/SmsPrices/SmsPrice";

	public static final String APPLE_SUCCESS = "apple_success";// 短信申请成功

	public static final String WARN_AUDIT = "warn_audit";// 审核错误提示

	public static final String SUCCESS_AUDIT = "success_audit";// 审核通过

	public static final String SOAP_SERIVCE = "ThirdWebservice";// webservice的一个容器--一卡通

	public static final String SOAP_PORT = "ThirdWebserviceSoap";// webservice具体的实现类--一卡通

	public static final String SOAP_TARGETNAMESPACE = "http://www.hzsun.com/";// wsdl的namespace
																				// 也就是wsdl的id----一卡通

	public static final String SOAP_SECURITY_HEARDER = "SecurityHeader";// 用于soap协议

	public static final String SUCCESS_SYNC = "success_sync";// 同步成功

	public static final String WARN_SYNC = "warn_sync";// 同步有误

	public static final String WARN_SIGNIN = "warn_signin";// 请先签到

	public static final String SUCCESS_SIGNIN = "success_signin";// 签到成功

	public static final int ADD_SOURCE_TYPE = 219;// MARC字段模板配置是否添加数据源数据字典类型

	public static final int PAY_STATUS_DIC_TYPE = 220;// 支付状态数据字典类型

	public static final int PAY_TYPE_DIC_TYPE = 221;// 罚款类型数据

	public static final int CATALOGUE_DIC_TYPE = 222;// 编目类型数据字典类型

	public static final int EASY_CATALOGUE = 1;// 简单编目

	public static final int DETAIL_CATALOGUE = 2;// 详细编目

	public static final int FEE_TYPE_DIC_TYPE = 223;// 费用类型数据字典类型

	public static final int IS_CANCEL_FEE = 1;// 丢书找回取消罚款

	public static final int SPECIAL_TYPE_DIC_TYPE = 225;// 阅览参数设置专项类型数据字典类型

	public static final Map<String, String> DATAMANAGE = new HashMap<String, String>();

	public static final String COUNT_MANAGER_NAME = "统计管理";// 数据统计链向统计管理

	public static final Object ACTIVE_ERROR = "active.error";

	public static final Object ACTIVE_SUCCESS = "active.success";

	public static final int SCHOOL_USER_STOP_DIC_TYPE = 224;// 学校用户停用标志数据字典类型

	public static final int SCHOOL_USER_NO_STOP = 1;// 学校用户允许

	public static final int SCHOOL_USER_IS_STOP = 2;// 学校用户停用

	public static final int READ_PARAM_FEE_DIC_TYPE = 226;// 阅览参数收费类型数据字典类型

	public static final int READ_PLACE_DIC_TYPE = 227;// 阅览室类型数据字典类型

	public static final int READ_REGIST_COUNT_SORT_DIC_TYPE = 228;// 阅览登记统计排序数据字典类型

	public static final int READ_REGIST_COUNT_SORT_BY_MAX_NUM = 1;// 按次数最多排序

	public static final int READ_REGIST_COUNT_SORT_BY_MAX_TIME = 2;// 按时间最多排序

	public static final String ERROR_READ_REGIST_COLLECTION_PLACE_NOT_FOUND = "Error.readRegist.collectionPlace.notFound";// 对应阅览室没有参数设置

	public static final String ERROR_READ_REGIST_READER_TYPE_NOT_FOUND = "Error.readRegist.readerType.notFound";// 对应读者类型没有参数设置

	public static final String ERROR_READ_REGIST_BEYOND_FREE_TIME = "Error.readRegist.beyond.free.time";// 超出免费阅览时间

	public static final String ERROR_READ_REGIST_IS_ANCIENT_PLACE = "Error.readRegist.is.ancient.place";// 属于古籍阅览室

	public static final String ERROR_READ_REGIST_NO_IN = "Error.readRegist.no.in";// 该读者未登入阅览室错误提示

	public static final String SUCCESS_READ_REGIST_IN = "Success.readRegist.regist.in";// 阅览登记登入成功提示

	public static final String SUCCESS_READ_REGIST_OUT = "Success.readRegist.regist.out";// 阅览登记登出成功提示

	public static final String ERROR_READR_EGIST_IS_IN = "Error.readRegist.is.in";// 读者已经在阅览室

	public static final String ERROR_READ_REGIST_HAS_IN = "Error.readRegist.hasReader.in";// 阅览室有读者尚未登出

	public static final String ERROR_READ_PLACE_SEAT_IS_FULL = "Error.readPlaceSet.is.full";// 阅览登记座位已满提示

	public static final int READER_CARD_TYPE_NOMAL = 1;// 读者卡户类型普通卡

	public static final int READER_CARD_TYPE_VIP = 2;// 读者卡户类型VIP卡

	public static final int READ_IS_FREE = 1;// 阅览参数属于免费类型

	public static final int CLOUD_MANAGER_STATUS_DIC = 229;// 云端维护处理状态

	// 详细编目marc重要字段

	public static final String MARC_049 = "049";// 编目员代码

	public static final String MARC_090 = "090";// 未知分类号

	public static final String MARC_091 = "091";// 统一书刊号

	public static final String MARC_205 = "205";// 版次

	public static final String MARC_207 = "207";// 连续出版物卷期编号

	public static final String MARC_300 = "300";// 一般性附注

	public static final String MARC_327 = "327";// 内容附注

	public static final String MARC_345 = "345"; // 采防附注

	public static final String MARC_410 = "410";// 丛编

	public static final String MARC_411 = "411";// 子丛编

	public static final String MARC_461 = "461";// 总集

	public static final String MARC_462 = "462";// 分集

	public static final String MARC_500 = "500"; // 统一题名

	public static final String MARC_510 = "510"; // 并列题名

	public static final String MARC_512 = "512"; // 封面题名

	public static final String MARC_516 = "516"; // 书籍题名

	public static final String MARC_517 = "517"; // 其它题名

	public static final String MARC_540 = "540"; // 编目人员补充的附加题名

	public static final String MARC_600 = "600"; // 个人名称主题

	public static final String MARC_601 = "601"; // 团体名称主题

	public static final String MARC_605 = "605"; // 题名主题

	public static final String MARC_607 = "607"; // 地名主题

	public static final String MARC_610 = "610"; // 非控主题词

	public static final String MARC_686 = "686"; // 其它分类法类号

	public static final String MARC_692 = "692"; // 中国科学院图书馆图书分类号

	public static final String MARC_702 = "702"; // 个人名称-次要责任者

	public static final String MARC_711 = "711"; // 团体名称－第一责任者

	public static final String MARC_712 = "712"; // 团体名称－次要责任者

	public static final String MARC_730 = "730"; // 非规范责任者

}
