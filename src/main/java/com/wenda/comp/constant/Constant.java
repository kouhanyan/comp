package com.wenda.comp.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description: ������
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class Constant {

	public static final String MESSAGE_SUCCESS = "message_success";// �����ɹ���ʶ��

	public static final String MESSAGE_ERROR = "message_error";// ���������ʶ��

	public static final String MESSAGE_WARN = "message_warn";// ���������ʶ��

	public static final String SUCCESS_ADD = "Success.add";// ������ӳɹ���ʾ

	public static final String SUCCESS_EDIT = "Success.edit";// �����޸ĳɹ���ʾ

	public static final String SUCCESS_DELETE = "Success.delete";// ����ɾ���ɹ���ʾ

	public static final String SUCCESS_RECOVER = "Success.recover";// ���ݻ�ԭ�ɹ���ʾ

	public static final String SUCCESS_START = "Success.start";// �����ɹ���ʾ

	public static final String SUCCESS_STOP = "Success.stop";// ��ͣ�ɹ���ʾ

	public static final String SUCCESS_BATCH_WORKBATCH = "Success.batch.workBatch";// ��ǰ�����������óɹ���ʾ

	public static final String SUCCESS_BATCH_CLEAR = "Success.batch.clear";// �������Ԥ�����ݳɹ���ʾ

	public static final String SUCCESS_BOOKINFORM_INFORMONE = "Success.bookInform.informOne";// ����ͨ���ɹ���ʾ

	public static final String SUCCESS_BOOKINFORM_CANCEL = "Success.bookInform.cancelOne";// ȡ��ͨ���ɹ���ʾ

	public static final String SUCCESS_BOOKRECOMMEND_SETORDER = "Success.bookRecommend.setOrder";// ����״̬���óɹ���ʾ

	public static final String SUCCESS_READER_PASSWORD_FINDBACK = "Success.reader.password.findBack";// ���뷢��������ɹ���ʾ

	public static final String ERROR_BOOKRECOMMEND_SETORDER = "Error.bookRecommend.setOrder";// ����ʧ����ʾ

	public static final String SUCCESS_BOOKORDER_ORDER = "Success.BookOrder.order";// ͼ��Ԥ���ɹ���ʾ

	public static final String SUCCESS_BOOKORDER_CANCEL = "Success.BookOrder.cancel";// ͼ���˶��ɹ���ʾ

	public static final String SUCCESS_ORDER_RECORD_EDIT = "Success.order.record.edit";// Ԥ����¼�޸ĳɹ�

	public static final String SUCCESS_COLLECTION_STATUS_DEAL = "Success.collection.status.deal";// �ݲ�״̬����ɹ���ʾ

	public static final String SUCCESS_COLLECTION_REGIST = "Success.collection.regist";// �ݲصǼǳɹ���ʾ

	public static final String SUCCESS_COLLECTION_REJECT = "Success.collection.reject";// �ݲ��޳��ɹ���ʾ

	public static final String SUCCESS_COLLECTION_REPLACE = "Success.collection.replace";// �����û��ɹ���ʾ

	public static final String ERROR_ADD = "Error.save";// �������ʧ����ʾ

	public static final String ERROR_EDIT = "Error.edit";// �����޸�ʧ����ʾ

	public static final String ERROR_DELETE = "Error.delete";// ����ɾ��ʧ����ʾ

	public static final String ERROR_FILE_EXPORT = "Error.file.export";// �ļ�����ʧ��

	public static final String ERROR_FILE_IMPORT = "Error.file.import";// �ļ�����ʧ��

	public static final String ERROR_REPEAT_SUBMIT = "Error.repeat.submit";// ���ظ��ύ

	public static final String ERROR_NO_QUERY_CONDITION = "Error.no.query.condition";// û�в�ѯ����������ʾ

	public static final String ERROR_BOOK_ORDER_CANCEL = "Error.BookOrder.cancel";// ͼ���Ѿ��˶��ٴ�Ԥ��������ʾ

	public static final String WARN_BOOK_ORDER_NO_BOOK = "Warn.BookOrder.noBook";// û��ͼ�鱻Ԥ��������ʾ

	public static final String ERROR_BATCH_WORKBATCH = "Error.batch.workBatch";// ������������Ϊ����״̬������ʾ

	public static final String ERROR_ORDERBATCH_WORKBATCH = "Error.orderBatch.workBatch";// ����Ԥ������ΪΪ����״̬������ʾ

	public static final String ERROR_BIBLIOPARAMSET_Z3950 = "Error.biblioParamSet.z3950";// ����Ԥ������ΪΪ����״̬������ʾ

	public static final String ERROR_BIBLIOACCEPTANCEBOOK_DELETED_COLLECTION = "Error.biblioAcceptanceBook.deleted.collection";// ���ռ�¼������ɾ�ݲ��б������ʾ

	public static final String ERROR_Z3950_BEYOND = "Error.z3950Limit.beyond";// z3950�����������ƴ�����ʾ

	public static final String WARN_USER_LIMIT = "Warn.user.limit";// �û������Ѵ�������ʾ

	public static final String WARN_MARC_DATA_IS_NULL = "Warn.marc.data.is.null";// marc����Ϊ�գ��޷�������ϸ��Ŀ����

	public static final String WARN_BOOKCIRCULATETYPE_EXIST = "Warn.bookCirculateType.exist";// �������ʹ�����ʾ

	public static final String WARN_COLLECTION_BARCODE_NO_NEED_REGIST = "Warn.collection.barcodeNoNeedRegist";// ����������Ǽ���ʾ

	public static final String WARN_QUERY_NO = "Warn.query.no";// û�в�ѯ����ؼ�¼

	public static final String WARN_SYSDIC_EXIST = "Warn.sysDic.exist";// �����ֵ������ʾ

	public static final String WARN_SCHOOL_EXIST = "Warn.school.exist";// ѧУ������ʾ

	public static final String WARN_SYSREGION_EXIST = "Warn.sysRegion.exist";// �����ֵ������ʾ

	public static final String WARN_SYSUSER_EXIST = "Warn.sysUser.exist";// ϵͳ�û�������ʾ

	public static final String WARN_SYSPUBLISHER_EXIST = "Warn.sysPublisher.exist";// �����������ʾ

	public static final String WARN_FEEDBACK_NODEAL = "Warn.feedBack.noDeal";// ������Ϣδ����ɾ����ʾ

	public static final String WARN_BOOKSELLER_EXIST = "Warn.bookSeller.exist";// ���̴�����ʾ

	public static final String WARN_BUDGET_EXIST = "Warn.budget.exist";// �ʽ�Ԥ�������ʾ

	public static final String WARN_BATCH_EXIST = "Warn.batch.exist";// �������δ�����ʾ

	public static final String WARN_BATCH_WORKBATCH_NOTEXIST = "Warn.batch.workBatch.notExist";// ��ǰ�������β�������ʾ

	public static final String WARN_READER_NOTEXIST = "Warn.reader.notExist";// ���߲�������ʾ

	public static final String WARN_READER_EMAIL_NOTBIND = "Warn.reader.email.notBind";// ������δ������

	public static final String WARN_BATCH_CURRENTBATCH_NOT_WORKBATCH = "Warn.batch.currentBatchNotWorkBatch";// ��ǰѡ�����β��ǹ�������

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ORDERBATCH = "Warn.batch.currentBatchNotOrderBatch";// ��ǰԤ�����β�����Ԥ��״̬��ʾ

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ORDER_ACCEPT_BATCH = "Warn.batch.currentBatchNotOrderAcceptBatch";// ��ǰԤ�����β���������״̬��ʾ

	public static final String WARN_BATCH_CURRENTBATCH_NOT_ACCEPTBATCH = "Warn.batch.currentBatchNotAcceptBatch";// ��ǰ�������β���������״̬��ʾ

	public static final String WARN_BIBLIOPARAMSET_NOSET = "Warn.biblioParamSet.noSet";// ��Ŀ����δ������ʾ

	public static final String WARN_SELLER_BATCH_FINISH_NO_DELETE = "Warn.seller.batch.finish.no.delete";// ����������Ŀ�Ѿ�����޷�ɾ����ʾ

	public static final String WARN_ORDER_BATCH_HAS_ORDER_NO_EDIT = "Warn.order.batch.has.order.no.edit";// Ԥ�������Ѿ�Ԥ���޷��޸���ʾ

	public static final String WARN_ACCEPT_BATCH_HAS_ACCEPT_NO_EDIT = "Warn.accept.batch.has.accept.no.edit";// ���������Ѿ������޷��޸���ʾ

	public static final String WARN_SELLER_BATCH_FINISH_NO_EDIT = "Warn.seller.batch.finish.no.edit";// ����������Ŀ�Ѿ�����޷��޸���ʾ

	public static final int BIBLIO_AUTHORIZE_TYPE = 2;// ��Ŀ��Ȩ����

	public static final String WARN_BIBLIOAUTHORIZE_EXIST = "Warn.biblioAuthorize.exist";// ��Ŀ��Ȩ������ʾ

	public static final String ERROR_BIBLIOAUTHORIZE_NO_ALLOW = "Error.biblioAurhorize.no.allow";// ��Ŀδ�õ���Ȩ

	public static final String ERROR_BIBLIOAUTHORIZE_BEYOND = "Error.biblioAurhorize.beyond";// ʵ�ʱ�Ŀ���������������

	public static final String WARN_COLLECTION_NOTEXIST = "Warn.collection.notExist";// �ݲ���Ϣ��������ʾ

	public static final String WARN_COLLECTION_NOTINSTATUS = "Warn.collection.notInStatus";// �ݲ�״̬�����ڹ�״̬��ʾ

	public static final String WARN_COLLECTION_NEWBARCODEEXIST = "Warn.collection.newBarcodeExist";// ��������Ѿ�������ʾ

	public static final String WARN_COLLECTION_ISLEND_STATUS = "Warn.collection.isLendStatus";// �ݲ����״̬

	public static final String WARN_COLLECTION_ISLOSE_STATUS = "Warn.collection.isLoseStatus";// �ݲض�ʧ״̬

	public static final String WARN_COLLECTION_HAS_PAY = "Warn.collection.has.pay";// �ݲش��ڷ���

	public static final String WARN_COLLECTION_LEND_NO_DELETE = "Warn.collection.lendNoDelete";// �ݲ����״̬���޷�ɾ����ʾ

	public static final String ERROR_COLLECTION_BARCODE_REPEAT = "Error.collection.barcode.repeat";// ������ظ�

	public static final String WARN_COLLECTION_ISDELETED = "Warn.collection.isDeleted";// ���ڹݲ���ɾ��¼�ľ�����ʾ

	public static final String WARN_READPARAMSET_EXIST = "Warn.readParamSet.exist";// �����������ô�����ھ�����ʾ

	public static final String WARN_READPARAMSET_HASCOLLECTIONPLACE = "Warn.readParamSet.hasCollectionPlace";// ��Ӧ�ݲص������������ھ�����ʾ

	public static final int COLLECTION_NOTEXIST_MARK = 1;// �ݲ���Ϣ�����ڱ�־

	public static final int COLLECTION_NOTINSTATUS_MARK = 2;// �ݲ�״̬�����ڹ�״̬��־

	public static final int COLLECTION_NEWBARCODEEXIST_MARK = 3;// ��������Ѿ����ڱ�־

	public static final String MD5 = "MD5";// md5�㷨��ʶ

	public static final int PAGE_SIZE = 10;// ÿҳ��ʾ��¼����

	public static final String ID = "id"; // id����

	public static final String SUCCESS_LIST = "success_list";// excel�����ɹ���¼��ʶ

	public static final String FAIL_LIST = "fail_list";// excel����ʧ�ܼ�¼��ʶ

	public static final String ROW_NUM = "row_num";// excel��Ӧ�к�

	public static final String PAGE_KEY = "page";// ��ҳ���ݼ�ֵ

	public static final String TOKEN_KEY = "token_key";// ���Ƽ�ֵ

	public static final String REPEAT_SUBMIT = "Error.repeat.submit";// ���ظ��ύ

	public static final String LOGIN_ERROR = "login_error";// ��½����

	public static final String LOGIN_ERROR_INFO = "�û������������!";// ��¼��ʾ

	public static final String ORGNIZE_TYPE = "orgnize_type";// ��֯����

	public static final String LOCAL_USER = "local_user";// ��ǰ��¼�û���ֵ

	public static final int SCHOOL_TYPE = 1;// ѧУ����

	public static final int BUDGET_TYPE = 4;// �ʽ�Ԥ������

	public static final int SCHOOL_BILL_TYPE = 5;// Ʊ������

	public static final int SCHOOL_BILL_PAY_TYPE = 6;// ���ʽ����

	public static final int MARC_FORMAT = 7;// �������

	public static final String UNIMARC = "unimarc";// unimarc��ʽ��

	public static final int BOOK_TYPE = 8;// ��������

	public static final int IS_ALL = 0;// �����Ӧ����������

	public static final int IS_BOOK = 1;// ͼ��

	public static final int IS_MAGAZINE = 2;// �ڿ�

	public static final int NO_BOOK = 3;// ��������

	public static final int BATCH_STATUS = 9;// ������������״̬

	public static final int SELLER_CATALOG_STATUS = 32;// ��������Ŀ¼����״̬

	public static final int ORDER_BATCH_STATUS = 33;// ͼ��Ԥ����������״̬

	public static final int ORDER_TYPE = 34;// ͼ��Ԥ����¼����(Ԥ��/�˶�)

	public static final int CHINA_LIB_CLASS_TYPE = 36;// ��ͼ���෨�������ֵ��е�����

	// ͼ��������������
	public static final int BATCH_CHECK_STATUS = 1;// ��������Ĭ�ϳ�ʼ״̬(����)

	public static final int BATCH_FINISH_STATUS = 2;// �����������״̬

	public static final int BATCH_HISTORY_STATUS = 3;// ����������ʷ״̬

	// ����������������
	public static final int BATCH_RECEIVE_STATUS = 1;// �����������ν���״̬

	// ͼ��Ԥ����������
	public static final int ORDER_BATCH_ORDER_STATUS = 1;// ͼ��Ԥ������Ԥ��״̬

	public static final int ORDER_BATCH_CHECK_STATUS = 2;// ͼ��Ԥ����������״̬

	public static final int ORDER_BATCH_FINISH_STATUS = 3;// ͼ��Ԥ���������״̬

	public static final int ORDER_BATCH_HISTORY_STATUS = 4;// ͼ��Ԥ��������ʷ״̬

	// ����������������
	public static final int SELLER_BATCH_RECEIVE_STATUS = 1;// �����������ν���״̬

	public static final int SELLER_BATCH_FINISH_STATUS = 2;// ���������������״̬

	public static final int SELLER_BATCH_HISTORY_STATUS = 3;// ��������������ʷ״̬

	public static final int CURRENT_WORK_BATCH = 1;// ��ǰ��������

	public static final int IS_COMPANY = 1;// ��˾

	public static final int IS_DSS = 2;// ������

	public static final int IS_SCHOOL = 3;// ѧУ

	public static final String PAGE_PARAM = "param";// ��ҳ�������

	public static final String ERROR_FILE_CREATE = "Error.file.create";// �ļ�����ʧ��

	public static final String ERROR_FILE_PARSE = "Error.file.parse";// �ļ�����ʧ��

	public static final String ERROR_FILE_NOTFOUND = "Error.file.notFound";// �Ҳ���ָ���ļ�

	public static final String ERROR_DEPT_EXIST = "Error.dept.exist";// ������֯������ʾ

	public static final int MENU_ONE = 1;// һ���˵�

	public static final int MENU_TWO = 2;// �����˵�

	public static final int MENU_THREE = 3;// �����˵�

	public static final String ERROR_READERTYPE_EXIST = "Error_readertype_exist";// �������ʹ�����ʾ

	public static final String SALT = "salt";// ��ֵ

	public static final String USER_NAME_KEY = "user_name_key";// session�û�����ֵ

	public static final String DEFAULT_USERNAME = "cadmin";// ��˾��̨Ĭ���û�����

	public static final int BIBLIO_AUTHORIZE_INIT_COUNT = 0;// ��Ŀ��Ȩ��ʼ����

	public static final int DELETES_KEY = 1;// ��ɾ����Ч��

	public static final String COMP_PATH = "/comp/";// ��˾Ŀ¼����

	public static final String MANA_PATH = "/maneger/";// ����Ŀ¼����

	public static final String DSS_PATH = "/dss/";// ����Ŀ¼����

	public static final int FEED_BACK_TYPE = 3;// ������Ϣ״̬

	public static final int NOT_DEAL = 1;// ������Ϣδ����

	public static final int IS_DEAL = 2;// ������Ϣ�Ѵ���

	public static final int IS_VALID = 1;// ���ñ�ʶ

	public static final int NO_DELETE = 1;// û�б���ɾ

	public static final int IS_DELETE = 2;// �Ѿ���ɾ

	public static final int BIBLIO_DIRECT = 1;// ��Ŀ״̬-ֱ�ӽ���

	public static final int BIBLIO_ORIGINAL = 2;// ��Ŀ״̬-ԭ��

	public static final int BIBLIO_RECEIVE_SELLER = 3;// ��������

	public static final int BIBLIO_Z3950_ADD = 4;// ��Ŀ״̬-z3950����

	public static final int BIBLIO_Z3950_MERGE = 5;// ��Ŀ״̬-z3950�ϲ�

	public static final int NO_REGIST = 1;// �ݲػ�û�еǼ�

	public static final int HAD_REGIST = 2;// �ݲ��Ѿ��Ǽǹ�

	public static final int BARCODE_SETTING = 12;// ���������������

	public static final int BARCODE_TYPE = 13;// ��������

	public static final int MEDIA_TYPE = 14;// ��������

	public static final int BOOK_SOURCE = 15;// ������Դ

	public static final int BIND_INFO = 16;// װ֡��ʽ

	public static final int REGION_PROVINCE = 1;// ʡ������

	public static final int REGION_CITY = 2;// �м�����

	public static final int REGION_COUNTY = 3;// �ؼ�����

	public static final int COLLECTION_INIT_LEND_NUM = 0;// �ݲس�ʼ������

	public static final int COLLECTION_STATUS = 22;// �ݲ�����״̬

	public static final int COLLECTION_INIT_STATUS = 1;// �ݲس�ʼ״̬(�ڹ�)

	public static final int COLLECTION_LEND_STATUS = 2;// �ݲ����״̬

	public static final int COLLECTION_LOSE_STATUS = 3;// �ݲض�ʧ״̬

	public static final int COLLECTION_DAMAGE_STATUS = 4;// �ݲ���״̬

	public static final int COLLECTION_REJECT_STATUS = 5;// �ݲ��޳�״̬

	public static final int COLLECTION_OTHER_STATUS = 6; // �ݲ�����״̬

	public static final int COLLECTION_TYPE = 17;// �ݲ�����

	public static final int COLLECTION_INIT_TYPE = 1;// �ݲس�ʼ����

	public static final int COLLECTION_PLACE_NO_REGIST = 1;// �ݲصز���Ҫ�Ǽ�

	public static final int COLLECTION_PLACE_IS_REGIST = 2;// �ݲص���Ҫ�Ǽ�

	public static final int COLLECTION_NORMAL_STATE = 1;// �ݲ�������־(δ����ɾ��)

	public static final int COLLECTION_DELETE_STATE = 2;// �ݲ�����ɾ����־

	public static final int INIT_COPIES = 1;// ��ʼ������

	public static final int INIT_VOL_NUM = 1;// ��ʼ�������

	public static final String INIT_VOL_INFO = "1";// ��ʼ�������Ϣ

	public static final int LOSE_FEE_TYPE = 18;// ���鷣�ʽ

	public static final int LOSE_PAY_TYPE = 19;// ���鷣������

	public static final int RENEW_TYPE = 20;// ���ڼ��㷽��

	public static final int COLLECTION_PLACE_REGIST = 21;// �ݲ��Ƿ���Ǽ�

	public static final int IS_DEFAULT = 1;// �ݲصص����������Ĭ�ϱ�ʶ

	public static final int BIBLIO_SHARE = 23;// ��Ŀ�����Ƿ���

	public static final int BIBLIO_IS_SHARE = 1;// ��Ŀ���ݹ���

	public static final int BIBLIO_NO_SHARE = 2;// ��Ŀ���ݲ�����

	public static final int READER_STATUS = 24;// ����״̬

	public static final int SEX_STATUS = 25;// �Ա�״̬

	public static final int BOOK_RECOMMEND_STATUS = 26;// ͼ�����״̬

	public static final int BOOK_HAD_INFORM = 1;// �����Ѿ�ͨ��״̬

	public static final String XLS = ".xls";// excel��׺2003

	public static final String XLSX = ".xlsx";// excel��׺2007

	public static final int BOOK_RECOMMEND_NODEAL = 1;// ͼ�����δ����

	public static final int BOOK_RECOMMEND_ORDER = 2;// ͼ������Ѷ���

	public static final int BOOK_RECOMMEND_BUY = 3;// ͼ������ѹ���

	public static final int BATCH_TYPE_ORDER = 1;// ����

	public static final int BATCH_TYPE_ACCEPT = 2;// ����

	public static final int BATCH_TYPE_BOOK_SELLER = 3;// ������Ŀ����

	public static final int BATCH_TYPE_SERIES_ORDER = 4;// �ڿ�����

	// ��ϸ��Ŀmarc��Ҫ�ֶ�
	public static final String MARC_HEA = "HEA";// ͷ����

	public static final String MARC_000 = "000";// ͷ����

	public static final String MARC_001 = "001";// ��¼���ƺ�

	public static final String MARC_005 = "005";// ��¼����ʱ���ʶ

	public static final String MARC_010 = "010";// isbn

	public static final String MARC_100 = "100";// ͨ�ô�������

	public static final String MARC_101 = "101";// ��Ʒ����

	public static final String MARC_102 = "102";// �������������

	public static final String MARC_105 = "105";// ר��

	public static final String MARC_106 = "106";// ����������̬����

	public static final String MARC_200 = "200";// ��������������

	public static final String MARC_210 = "210";// ���淢����

	public static final String MARC_215 = "215";// ������̬��

	public static final String MARC_225 = "225";// �Ա���

	public static final String MARC_330 = "330";// ��Ҫ����ժ

	public static final String MARC_606 = "606";// ��ͨ����

	public static final String MARC_690 = "690";// ��ͼ�����

	public static final String MARC_701 = "701"; // ������̬��

	public static final String MARC_801 = "801";// ������̬��

	public static final String MARC_905 = "905";// �ݲ���Ϣ

	public static final String MARC_011 = "011";// ISSN

	public static final String MARC_092 = "092";// ������

	public static final String MARC_326 = "326";// ����Ƶ��

	// ����ͳ���嵥������ͷ
	public static final Map<String, String> getBiblioOldBookTitles() {
		Map<String, String> biblioOldBookTitles = new LinkedHashMap<String, String>();
		biblioOldBookTitles.put("0", "���");
		biblioOldBookTitles.put("1", "ISBN");
		biblioOldBookTitles.put("2", "����");
		biblioOldBookTitles.put("3", "����");
		biblioOldBookTitles.put("4", "�۸�");
		biblioOldBookTitles.put("5", "����");
		biblioOldBookTitles.put("6", "�ܽ��");
		return biblioOldBookTitles;
	}

	// ����ͨ���嵥������ͷ
	// public static final Map<String, String> bookInformTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// bookInformTitles.put("0", "���");
	// bookInformTitles.put("1", "ISBN");
	// bookInformTitles.put("2", "����");
	// bookInformTitles.put("3", "����");
	// bookInformTitles.put("4", "�����");
	// }

	public static final Map<String, String> getBookInformTitles() {
		Map<String, String> bookInformTitles = new LinkedHashMap<String, String>();
		bookInformTitles.put("0", "���");
		bookInformTitles.put("1", "ISBN");
		bookInformTitles.put("2", "����");
		bookInformTitles.put("3", "����");
		bookInformTitles.put("4", "�����");
		return bookInformTitles;
	}

	// ͼ������嵥��ͷ
	// public static final Map<String, String> bookRecommendTitls = new
	// LinkedHashMap<String, String>();
	// static {
	// bookRecommendTitls.put("-1", "���");
	// bookRecommendTitls.put("0", "ISBN");
	// bookRecommendTitls.put("1", "�����");
	// bookRecommendTitls.put("2", "����");
	// bookRecommendTitls.put("3", "����");
	// bookRecommendTitls.put("4", "����");
	// bookRecommendTitls.put("5", "������");
	// bookRecommendTitls.put("6", "��������");
	// bookRecommendTitls.put("7", "����");
	// bookRecommendTitls.put("8", "����״̬");
	// }

	public static final Map<String, String> getBookRecommendTitles() {
		Map<String, String> bookRecommendTitls = new LinkedHashMap<String, String>();
		bookRecommendTitls.put("-1", "���");
		bookRecommendTitls.put("0", "ISBN");
		bookRecommendTitls.put("1", "�����");
		bookRecommendTitls.put("2", "����");
		bookRecommendTitls.put("3", "����");
		bookRecommendTitls.put("4", "����");
		bookRecommendTitls.put("5", "������");
		bookRecommendTitls.put("6", "��������");
		bookRecommendTitls.put("7", "����");
		bookRecommendTitls.put("8", "����״̬");
		return bookRecommendTitls;
	}

	// ����ͳ����ͷ
	public static final Map<String, String> acceptCountTitles = new LinkedHashMap<String, String>();
	static {
		acceptCountTitles.put("0", "���");
		acceptCountTitles.put("1", "ISBN");
		acceptCountTitles.put("2", "����");
		acceptCountTitles.put("3", "������");
		acceptCountTitles.put("4", "����ʱ��");
		acceptCountTitles.put("5", "���ղ���");
	}

	// ��Ŀ����ͳ����ͷ
	public static final Map<String, String> biblioCountTitles = new LinkedHashMap<String, String>();
	static {
		biblioCountTitles.put("0", "���");
		biblioCountTitles.put("1", "�����");
		biblioCountTitles.put("2", "����");
	}

	public static final Map<String, String> z3950DownLoadCountTitles = new LinkedHashMap<String, String>();
	static {
		z3950DownLoadCountTitles.put("0", "���");
		z3950DownLoadCountTitles.put("1", "����Ա");
		z3950DownLoadCountTitles.put("2", "����");
		z3950DownLoadCountTitles.put("3", "Z3950����");
		z3950DownLoadCountTitles.put("4", "����");
	}

	// �ݲ��嵥��ͷ
	// public static final Map<String, String> collectionBillTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionBillTitles.put("0", "���");
	// collectionBillTitles.put("1", "�����");
	// collectionBillTitles.put("2", "�����");
	// collectionBillTitles.put("3", "����");
	// collectionBillTitles.put("4", "����");
	// collectionBillTitles.put("5", "ISBN");
	// collectionBillTitles.put("6", "������");
	// collectionBillTitles.put("7", "����ʱ��");
	// collectionBillTitles.put("8", "����");
	// collectionBillTitles.put("9", "�ݲ�״̬");
	// collectionBillTitles.put("10", "���ʱ��");
	// collectionBillTitles.put("11", "����ʱ��");
	// collectionBillTitles.put("12", "����Ա");
	// }

	public static final Map<String, String> getCollectionBillTitles() {
		Map<String, String> collectionBillTitles = new LinkedHashMap<String, String>();
		collectionBillTitles.put("0", "���");
		collectionBillTitles.put("1", "�����");
		collectionBillTitles.put("2", "�����");
		collectionBillTitles.put("3", "����");
		collectionBillTitles.put("4", "����");
		collectionBillTitles.put("5", "ISBN");
		collectionBillTitles.put("6", "������");
		collectionBillTitles.put("7", "����ʱ��");
		collectionBillTitles.put("8", "����");
		collectionBillTitles.put("9", "�ݲ�״̬");
		collectionBillTitles.put("10", "���ʱ��");
		collectionBillTitles.put("11", "����ʱ��");
		collectionBillTitles.put("12", "����Ա");
		return collectionBillTitles;
	}

	// �ݲط���ͳ����ͷ
	// public static final Map<String, String> collectionClassTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionClassTitles.put("0", "���");
	// collectionClassTitles.put("1", "����");
	// collectionClassTitles.put("2", "����");
	// collectionClassTitles.put("3", "����");
	// collectionClassTitles.put("4", "���ۺ�");
	// }

	public static final Map<String, String> getCollectionClassTitles() {
		Map<String, String> collectionClassTitles = new LinkedHashMap<String, String>();
		collectionClassTitles.put("0", "���");
		collectionClassTitles.put("1", "����");
		collectionClassTitles.put("2", "����");
		collectionClassTitles.put("3", "����");
		collectionClassTitles.put("4", "���ۺ�");
		return collectionClassTitles;
	}

	// public static final Map<String, String> collectionPlaceTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// collectionPlaceTitles.put("0", "���");
	// collectionPlaceTitles.put("1", "�ݲصص�");
	// collectionPlaceTitles.put("2", "����");
	// collectionPlaceTitles.put("3", "����");
	// collectionPlaceTitles.put("4", "����");
	// collectionPlaceTitles.put("5", "���ۺ�");
	// }

	public static final Map<String, String> getCollectionPlaceTitles() {
		Map<String, String> collectionPlaceTitles = new LinkedHashMap<String, String>();
		collectionPlaceTitles.put("0", "���");
		collectionPlaceTitles.put("1", "�ݲصص�");
		collectionPlaceTitles.put("2", "����");
		collectionPlaceTitles.put("3", "����");
		collectionPlaceTitles.put("4", "����");
		collectionPlaceTitles.put("5", "���ۺ�");
		return collectionPlaceTitles;
	}

	// public static final Map<String,String> logCountTitles=new
	// LinkedHashMap<String, String>();
	// static{
	// logCountTitles.put("0", "���");
	// logCountTitles.put("1", "����Ա");
	// logCountTitles.put("2", "��������");
	// logCountTitles.put("3", "����");
	// }

	public static final Map<String, String> getLogCountTitles() {
		Map<String, String> logCountTitles = new LinkedHashMap<String, String>();
		logCountTitles.put("0", "���");
		logCountTitles.put("1", "����Ա");
		logCountTitles.put("2", "��������");
		logCountTitles.put("3", "����");
		return logCountTitles;
	}

	// ���߲ƾ�excel��ͷ
	public static final Map<String, String> getReaderFinanceTitles() {
		Map<String, String> readerFinanceTitles = new LinkedHashMap<String, String>();
		readerFinanceTitles.put("0", "���");
		readerFinanceTitles.put("1", "��������");
		readerFinanceTitles.put("2", "����");
		readerFinanceTitles.put("3", "�����");
		readerFinanceTitles.put("4", "�����");
		readerFinanceTitles.put("5", "���");
		readerFinanceTitles.put("6", "��������");
		return readerFinanceTitles;
	}

	// �տ�ͳ��excel��ͷ
	public static final Map<String, String> getReceiveMoneyCountTitles() {
		Map<String, String> receiveMoneyCountTitles = new LinkedHashMap<String, String>();
		receiveMoneyCountTitles.put("0", "���");
		receiveMoneyCountTitles.put("1", "����Ա");
		receiveMoneyCountTitles.put("2", "���");
		return receiveMoneyCountTitles;
	}

	// �ƾ�����ͳ��excel��ͷ
	public static final Map<String, String> getFinanceClassCountTitles() {
		Map<String, String> bookFinanceClassCountTitles = new LinkedHashMap<String, String>();
		bookFinanceClassCountTitles.put("0", "���");
		bookFinanceClassCountTitles.put("1", "�ƾ�����");
		bookFinanceClassCountTitles.put("2", "���");
		return bookFinanceClassCountTitles;
	}

	public static final Map<String, String> getBookFinanceClassCountTitles() {
		Map<String, String> bookFinanceClassCountTitles = new LinkedHashMap<String, String>();
		bookFinanceClassCountTitles.put("0", "���");
		bookFinanceClassCountTitles.put("1", "������������");
		bookFinanceClassCountTitles.put("2", "���");
		return bookFinanceClassCountTitles;
	}

	public static final String READER_FINANCE_EXPORT_NAME = "���߲ƾ�����";// ���߲ƾ������嵥��������

	public static final String RECEIVE_MONEY_COUNT_EXPORT_NAME = "�տ�ͳ��";// �տ�ͳ���嵥��������

	public static final String FINANCE_CLASS_COUNT_EXPORT_NAME = "�ƾ�����ͳ��";// �ƾ������嵥��������

	public static final String BOOK_FINANCE_CLASS_COUNT_EXPORT_NAME = "���׷���ƾ�ͳ��";// ��������ƾ�ͳ���嵥��������

	public static final String LOG_COUNT_EXPORT_NAME = "��־ͳ��";// ��־ͳ���嵥��������

	public static final String BOOK_INFORM_EXPORT_NAME = "����ͨ�������嵥";// ����ͨ���嵥��������

	public static final String BOOK_RECOMMEND_EXPORT_NAME = "ͼ������б�";// ͼ������嵥��������

	public static final String SERIES_BOOK_RECOMMEND_EXPORT_NAME = "�ڿ������б�";// �ڿ������嵥��������

	public static final String BIBLIO_OLD_BOOK_EXPORT_NAME = "����ͳ��";// ����ͳ�Ƶ�������

	public static final String ACCEPT_COUNT_EXPORT_NAME = "����ͳ��";// ����ͳ�Ƶ�������

	public static final String COLLECTION_BILL_EXPORT_NAME = "�ݲ��嵥";// �ݲ��嵥��������

	public static final String COLLECTION_CLASS_EXPORT_NAME = "�ݲط���ͳ��";// �ݲط���ͳ�Ƶ�������

	public static final String COLLECTION_PLACE_EXPORT_NAME = "�ݲصص�ͳ��";// �ݲصص�ͳ�Ƶ�������

	public static final String OVERDUE_LIST_NAME = "�߻��嵥";// �߻��嵥��������

	public static final String BIBLIO_COUNT_EXPORT_NAME = "��Ŀ����ͳ��";// ��Ŀ����ͳ�Ƶ�������

	public static final String Z3950_DOWNLOAD_COUNT_EXPORT_NAME = "z3950����ͳ��";// z3950����ͳ�Ƶ�������

	public static final String READER_BARCODE_NOEXIST = "reader_barcode_noexist"; // ���߿��Ų�������ʾ

	public static final String COLLECTION_BARCODE_NOEXIST = "collection_barcode_noexist"; // �ݲ����벻������ʾ

	public static final int ATTACHMENT_MARK = 27; // ������ʶ

	public static final int ATTACHMENT_MARK_KEY = 1; // �����������

	public static final int RETURNED_MARK_KEY = 1; // �ѻ�

	public static final int LEND_MARK_KEY = 2; // ���

	public static final int LEND_RULE_TYPE = 28; // �����������

	public static final int ORDER_SOURCE = 41;// Ԥ����Դ�����ֵ�����

	public static final int LEND_RENEW_COUNT = 0; // ��ʼ���������

	public static final int LEND_RULE_TYPE_ONE = 1; // �����������Ϊһ����ͨ���

	public static final String LEND_SUCCESS = "lend_success"; // ����ɹ�

	public static final String LEND_SUPERIOR_LIMIT = "lend_superior_limit"; // �����Ѵ�����

	public static final String READER_EXPIRED = "reader_expired"; // ���߹���

	public static final String COLLECTION_LEND = "collection_lend"; // ͼ�鲻�ڹ�

	public static final String LEND_BARCODE_NOEXIST = "lend_barcode_noexist"; // ���ļ�¼��������ʾ

	public static final String RETURNED_SUCCESS = "returned_success";// ����ɹ���ʾ

	public static final String LEND_COLLECTION_LIMIT = "lend_collection_limit"; // ���߲��ܽ��ĸù�ͼ����ʾ

	public static final String WARN_SERIESCURRENCY_EXIST = "Warn.seriesCurrency.exist";// ���ң��ڿ��������Ѵ���

	public static final String WARN_SERIESCYCLE_EXIST = "Warn.seriesCycle.exist";// ���ڴ����Ѿ�����

	public static final int BOOK_ORDER_STATUS = 1;// ͼ��Ԥ��״̬

	public static final int BOOK_CANCEL_ORDER_STATUS = 2;// ͼ���˶�״̬

	public static final int CHAESET = 30;// �����ַ����뼯

	public static final int SERIES_TYPE = 31;// �ڿ����

	public static final int SERIES_ORDER_TYPE = 35;// �ڿ�Ԥ������

	public static final int SERIES_ORDER_TYPE_RESEVATION = 1;// Ԥ��

	public static final int SERIES_ORDER_TYPE_RENEW = 2;// ����

	public static final int SERIES_ORDER_TYPE_UNSUBSCRIBE = 3;// �˶�

	public static final int SERIES_ORDER_TYPE_STOP = 4;// ͣ��

	public static final int SERIES_ORDER_TYPE_DIRECTLY = 5;// ֱ�Ӽǵ�

	public static final String SERIES_ORDER_UNSUBSCRIBE_ERROR = "Warn.unsubscribe.error";// ͣ����¼�����˶�

	public static final String SUCCESS_SERIES_ORDER_STOP = "Success.seriesOrder.stop";// �ڿ�ͣ���ɹ�

	public static final String SUCCESS_SERIES_ORDER_RENEW = "Warn.seriesOrder.renew";// �ڿ������ɹ�

	public static final String SUCCESS_SERIES_ORDER_RENEW_SIZE = "Warn.seriesOrder.renew.size";

	public static final int READERSTAT_INIT_PREPAY = 0;// ������ʼ��Ѻ��

	public static final int READERSTAT_INIT_TOTAL_LEND_NUM = 0;// ������ʼ��Ѻ���������

	// public static final Map<String, String> overdueListTitles = new
	// LinkedHashMap<String, String>();
	// static {
	// overdueListTitles.put("0", "���");
	// overdueListTitles.put("1", "����֤��");
	// overdueListTitles.put("2", "��������");
	// overdueListTitles.put("3", "������֯");
	// overdueListTitles.put("4", "��������");
	// overdueListTitles.put("5", "����");
	// overdueListTitles.put("6", "�����");
	// overdueListTitles.put("7", "���ʱ��");
	// overdueListTitles.put("8", "Ӧ��ʱ��");
	// }

	public static final Map<String, String> getOverdueListTitles() {
		Map<String, String> overdueListTitles = new LinkedHashMap<String, String>();
		overdueListTitles.put("0", "���");
		overdueListTitles.put("1", "����֤��");
		overdueListTitles.put("2", "��������");
		overdueListTitles.put("3", "������֯");
		overdueListTitles.put("4", "��������");
		overdueListTitles.put("5", "����");
		overdueListTitles.put("6", "�����");
		overdueListTitles.put("7", "���ʱ��");
		overdueListTitles.put("8", "Ӧ��ʱ��");
		return overdueListTitles;
	}

	public static final int SERIES_ACCEPT_TYPE = 37;// Ԥ��������������

	public static final int SERIES_ACCEPT_RESERVATION = 1;// Ԥ������ reservation

	public static final int SERIES_ACCEPT_DIRECTLY = 2;// ֱ������directly

	public static final int SERIES_ACCEPT_STATE = 38;// �ڿ��ǵ�״̬���������ͣ�

	public static final int SERIES_ACCEPT_STATE_NOT_IN = 1;// δ�ǵ�

	public static final int SERIES_ACCEPT_STATE_IN = 2;// �ڹ�

	public static final int SERIES_ACCEPT_STATE_NOT_HERE = 3;// δ����

	public static final int SERIES_ACCEPT_STATE_BINDING = 4;// װ��

	public static final int SERIES_ACCEPT_STATE_PUSH_LACK = 5;// ��ȱ

	public static final int SERIES_ACCEPT_STATE_DELAY = 6;// �Ƴ�

	public static final int SERIES_ACCEPT_STATE_PUSH_NOT = 7;// �߲���

	public static final int SERIES_ACCEPT_STATE_CLOSURE = 8;// ͣ��

	public static final int SERIES_ACCEPT_STATE_REFUND = 9;// �˿�

	public static final int SERIES_ACCEPT_STATE_LOST = 10;// ��ʧ

	public static final String READER_BATCH_SUCCESS = "reader_batch_success"; // ����������ɹ�

	public static final Integer LEND_STATUS = 39; // ���߽���������ͨ״̬

	public static final Integer INIT_PERSONNUM = 10; // ���߽������а��ʼ��ͳ������

	public static Integer SERIES_MERGESIGN_FUSION = 1;// �Ͽ�

	public static Integer SERIES_MERGESIGN_NOT_FUSION = 2;// ���ǺϿ�

	public static Integer SERIES_BIND_STATUS = 40;// װ��״̬

	public static Integer SERIES_BIND_STATUS_BIND = 1;// װ��

	public static Integer SERIES_BIND_STATUS_SUBMIT = 2;// ����

	public static Integer SERIES_BIDN_STATUS_TIBET = 3;// ���

	public static Integer LEND_STATUS_RETURN_BACK = 1;// �ѻ�

	public static Integer LEND_STATUS_LEND = 2;// ���

	public static Integer LEND_STATUS_LOSE = 3;// ��ʧ

	public static Integer LEND_STATUS_BROKEN = 4;// �޳�

	public static Integer LEND_STATUS_OTHER = 5;// ����

	public static String LOSE_SUCCESS = "lose_success"; // ���鴦��

	public static String BROKEN_SUCCESS = "broken_success"; // ������

	public static String SERIES_BIND_SEND_SUCCESS = "series_bind_send_success";// �ڿ����ͳɹ�

	public static String READER_INIT_PASSWORD = "123456"; // ����Ĭ������

	public static Integer READER_STATUS_VALID = 1;// ��Ч

	public static Integer READER_STATUS_TEST = 2;// ��֤

	public static Integer READER_STATUS_LOSE = 3;// ��ʧ

	public static Integer READER_STATUS_STOP = 4;// ��ͣ

	public static Integer READER_STATUS_LOGOUT = 5;// ע��

	public static String SYS_MESSAGE_HEADER = "����ͼ��<";// ��Ϣ��Ϣ����ͷ

	public static final String BOOK_MARK_PRINT_ORDER_BY_DEFAULT = "default";// ����ӡĬ������ʽ

	public static final String BOOK_MARK_PRINT_ORDER_BY_CALLNO = "call_no";// ����ӡ�������������

	public static final String BOOK_MARK_PRINT_ORDER_BY_BARCODE = "barcode";// ����ӡ�������������

	public static final String BOOK_MARK_PRINT_ORDER_BY_TIME = "create_time";// ����ӡ�������ʱ������

	// public static final Map<String, String> BOOK_MARK_PRINT_ORDER_WAY = new
	// LinkedHashMap<String, String>();// ����ӡ����ʽ
	// static {
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_DEFAULT, "Ĭ��");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_CALLNO, "�����");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_BARCODE, "�����");
	// BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_TIME, "���ʱ��");
	// }

	public static final Map<String, String> getBookMarkPrintOrderWay() {
		Map<String, String> BOOK_MARK_PRINT_ORDER_WAY = new LinkedHashMap<String, String>();
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_DEFAULT, "Ĭ��");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_CALLNO, "�����");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_BARCODE, "�����");
		BOOK_MARK_PRINT_ORDER_WAY.put(BOOK_MARK_PRINT_ORDER_BY_TIME, "���ʱ��");
		return BOOK_MARK_PRINT_ORDER_WAY;
	}

	public static final int BOOK_MARK_PRINT_BARCODE_NO = 0;

	public static final int BOOK_MARK_PRINT_BARCODE_FRONT = 1;

	public static final int BOOK_MARK_PRINT_BARCODE_BEHIND = 2;

	// public static final List<String> BOOK_MARK_PRINT_BARCODE_WAY = new
	// LinkedList<String>();// ����ӡ������ʾ��ʽ
	//
	// static {
	// BOOK_MARK_PRINT_BARCODE_WAY.add("��");
	// BOOK_MARK_PRINT_BARCODE_WAY.add("������ǰ");
	// BOOK_MARK_PRINT_BARCODE_WAY.add("�����ں�");
	// }

	public static final List<String> getBookMarkPrintBarcodeWay() {
		List<String> BOOK_MARK_PRINT_BARCODE_WAY = new LinkedList<String>();
		BOOK_MARK_PRINT_BARCODE_WAY.add("��");
		BOOK_MARK_PRINT_BARCODE_WAY.add("������ǰ");
		BOOK_MARK_PRINT_BARCODE_WAY.add("�����ں�");
		return BOOK_MARK_PRINT_BARCODE_WAY;
	}

	public static final int ORDER_OPTION = 42; // WebOpac��������ʽ

	public static final int ORDER_MODE = 43; // ��������ʽ

	public static final int ORDER_OPTION_CLASS_NO = 1; // WebOpac��������ʽ(�����)

	public static final int ORDER_OPTION_AUTHOR = 2; // WebOpac��������ʽ(����)

	public static final int ORDER_MODE_ASCENDING = 1; // ��������ʽ(����)

	public static final int ORDER_MODE_DESCENDING = 2; // ��������ʽ(����)

	// public static final Map<String, String> SERIES_REPORT_ORDER_ALL_SORT_WAY
	// = new LinkedHashMap<String, String>();// ��������������ʽ
	//
	// static {
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderNo", "������");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.title", "����");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("publisher", "������");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("bookSellerId", "����");
	// SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderTime", "����ʱ��");
	// }

	public static final Map<String, String> getSeriesReportOrderAllSortWay() {
		Map<String, String> SERIES_REPORT_ORDER_ALL_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderNo", "������");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("biblioTemp.title", "����");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("publisher", "������");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("bookSellerId", "����");
		SERIES_REPORT_ORDER_ALL_SORT_WAY.put("orderTime", "����ʱ��");
		return SERIES_REPORT_ORDER_ALL_SORT_WAY;
	}

	public static final String SERIES_REPORT_ORDER_ALL_EXPORT_NAME = "����������";

	// public static final Map<String, String> REPORT_ORDER_ALL_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_ALL_LIST.put("-1", "���");
	// REPORT_ORDER_ALL_LIST.put("0", "������");
	// REPORT_ORDER_ALL_LIST.put("1", "�����");
	// REPORT_ORDER_ALL_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_ALL_LIST.put("3", "����");
	// REPORT_ORDER_ALL_LIST.put("4", "������");
	// REPORT_ORDER_ALL_LIST.put("5", "�ֹݴ���");
	// REPORT_ORDER_ALL_LIST.put("6", "���̴���");
	// REPORT_ORDER_ALL_LIST.put("7", "Ԥ�����");
	// REPORT_ORDER_ALL_LIST.put("8", "����ʱ��");
	// REPORT_ORDER_ALL_LIST.put("9", "��������");
	// REPORT_ORDER_ALL_LIST.put("10", "������");
	// REPORT_ORDER_ALL_LIST.put("11", "�۸�");
	// REPORT_ORDER_ALL_LIST.put("12", "ԭ�׼�");
	// REPORT_ORDER_ALL_LIST.put("13", "�ܼ�");
	// REPORT_ORDER_ALL_LIST.put("14", "��������");
	// REPORT_ORDER_ALL_LIST.put("15", "���");
	// REPORT_ORDER_ALL_LIST.put("16", "�����");
	// }

	public static final Map<String, String> getReportOrderAllList() {
		Map<String, String> REPORT_ORDER_ALL_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_ALL_LIST.put("-1", "���");
		REPORT_ORDER_ALL_LIST.put("0", "������");
		REPORT_ORDER_ALL_LIST.put("1", "�����");
		REPORT_ORDER_ALL_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_ALL_LIST.put("3", "����");
		REPORT_ORDER_ALL_LIST.put("4", "������");
		REPORT_ORDER_ALL_LIST.put("5", "�ֹݴ���");
		REPORT_ORDER_ALL_LIST.put("6", "���̴���");
		REPORT_ORDER_ALL_LIST.put("7", "Ԥ�����");
		REPORT_ORDER_ALL_LIST.put("8", "����ʱ��");
		REPORT_ORDER_ALL_LIST.put("9", "��������");
		REPORT_ORDER_ALL_LIST.put("10", "������");
		REPORT_ORDER_ALL_LIST.put("11", "�۸�");
		REPORT_ORDER_ALL_LIST.put("12", "ԭ�׼�");
		REPORT_ORDER_ALL_LIST.put("13", "�ܼ�");
		REPORT_ORDER_ALL_LIST.put("14", "��������");
		REPORT_ORDER_ALL_LIST.put("15", "���");
		REPORT_ORDER_ALL_LIST.put("16", "�����");
		return REPORT_ORDER_ALL_LIST;
	}

	public static final String SERIES_REPORT_ORDER_NEW_EXPORT_NAME = "�¶�������";

	// public static final Map<String, String> REPORT_ORDER_NEW_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_NEW_LIST.put("-1", "���");
	// REPORT_ORDER_NEW_LIST.put("0", "������");
	// REPORT_ORDER_NEW_LIST.put("1", "�����");
	// REPORT_ORDER_NEW_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_NEW_LIST.put("3", "����");
	// REPORT_ORDER_NEW_LIST.put("4", "������");
	// REPORT_ORDER_NEW_LIST.put("5", "��������");
	// REPORT_ORDER_NEW_LIST.put("6", "�ֹݴ���");
	// REPORT_ORDER_NEW_LIST.put("7", "���̴���");
	// REPORT_ORDER_NEW_LIST.put("8", "Ԥ�����");
	// REPORT_ORDER_NEW_LIST.put("9", "��������");
	// REPORT_ORDER_NEW_LIST.put("10", "�۸�");
	// REPORT_ORDER_NEW_LIST.put("11", "ԭ�׼�");
	// REPORT_ORDER_NEW_LIST.put("12", "�ܼ�");
	// REPORT_ORDER_NEW_LIST.put("13", "�����");
	// }

	public static final Map<String, String> getReportOrderNewList() {
		Map<String, String> REPORT_ORDER_NEW_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_NEW_LIST.put("-1", "���");
		REPORT_ORDER_NEW_LIST.put("0", "������");
		REPORT_ORDER_NEW_LIST.put("1", "�����");
		REPORT_ORDER_NEW_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_NEW_LIST.put("3", "����");
		REPORT_ORDER_NEW_LIST.put("4", "������");
		REPORT_ORDER_NEW_LIST.put("5", "��������");
		REPORT_ORDER_NEW_LIST.put("6", "�ֹݴ���");
		REPORT_ORDER_NEW_LIST.put("7", "���̴���");
		REPORT_ORDER_NEW_LIST.put("8", "Ԥ�����");
		REPORT_ORDER_NEW_LIST.put("9", "��������");
		REPORT_ORDER_NEW_LIST.put("10", "�۸�");
		REPORT_ORDER_NEW_LIST.put("11", "ԭ�׼�");
		REPORT_ORDER_NEW_LIST.put("12", "�ܼ�");
		REPORT_ORDER_NEW_LIST.put("13", "�����");
		return REPORT_ORDER_NEW_LIST;
	}

	// public static final Map<String, String> SERIES_REPORT_ORDER_STOP_SORT_WAY
	// = new LinkedHashMap<String, String>();// ͣ������������ʽ
	//
	// static {
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderNo", "������");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.isbn", "ISBN");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.title", "����");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("publisher", "������");
	// SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderTime", "����ʱ��");
	// }

	public static final Map<String, String> getSeriesReportOrderStopSortWay() {
		Map<String, String> SERIES_REPORT_ORDER_STOP_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderNo", "������");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.isbn", "ISBN");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("biblioTemp.title", "����");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("publisher", "������");
		SERIES_REPORT_ORDER_STOP_SORT_WAY.put("orderTime", "����ʱ��");
		return SERIES_REPORT_ORDER_STOP_SORT_WAY;
	}

	public static final String SERIES_REPORT_ORDER_STOP_EXPORT_NAME = "ͣ��������";

	// public static final Map<String, String> REPORT_ORDER_STOP_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_STOP_LIST.put("-1", "���");
	// REPORT_ORDER_STOP_LIST.put("0", "������");
	// REPORT_ORDER_STOP_LIST.put("1", "�����");
	// REPORT_ORDER_STOP_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_STOP_LIST.put("3", "����");
	// REPORT_ORDER_STOP_LIST.put("4", "������");
	// REPORT_ORDER_STOP_LIST.put("5", "�ֹݴ���");
	// REPORT_ORDER_STOP_LIST.put("6", "ͣ�����");
	// REPORT_ORDER_STOP_LIST.put("7", "ͣ��ʱ��");
	// REPORT_ORDER_STOP_LIST.put("8", "��������");
	// REPORT_ORDER_STOP_LIST.put("9", "�����");
	// }

	public static final Map<String, String> getReportOrderStopList() {
		Map<String, String> REPORT_ORDER_STOP_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_STOP_LIST.put("-1", "���");
		REPORT_ORDER_STOP_LIST.put("0", "������");
		REPORT_ORDER_STOP_LIST.put("1", "�����");
		REPORT_ORDER_STOP_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_STOP_LIST.put("3", "����");
		REPORT_ORDER_STOP_LIST.put("4", "������");
		REPORT_ORDER_STOP_LIST.put("5", "�ֹݴ���");
		REPORT_ORDER_STOP_LIST.put("6", "ͣ�����");
		REPORT_ORDER_STOP_LIST.put("7", "ͣ��ʱ��");
		REPORT_ORDER_STOP_LIST.put("8", "��������");
		REPORT_ORDER_STOP_LIST.put("9", "�����");
		return REPORT_ORDER_STOP_LIST;
	}

	public static final String SERIES_REPORT_ORDER_LOST_EXPORT_NAME = "©��������";

	// public static final Map<String, String> REPORT_ORDER_LOST_LIST = new
	// LinkedHashMap<String, String>();
	// static {
	// REPORT_ORDER_LOST_LIST.put("-1", "���");
	// REPORT_ORDER_LOST_LIST.put("0", "������");
	// REPORT_ORDER_LOST_LIST.put("1", "�����");
	// REPORT_ORDER_LOST_LIST.put("2", "ISBN/ISSN");
	// REPORT_ORDER_LOST_LIST.put("3", "����");
	// REPORT_ORDER_LOST_LIST.put("4", "������");
	// REPORT_ORDER_LOST_LIST.put("5", "��������");
	// REPORT_ORDER_LOST_LIST.put("6", "�ֹݴ���");
	// REPORT_ORDER_LOST_LIST.put("7", "���̴���");
	// REPORT_ORDER_LOST_LIST.put("8", "Ԥ�����");
	// REPORT_ORDER_LOST_LIST.put("9", "����ʱ��");
	// REPORT_ORDER_LOST_LIST.put("10", "��������");
	// REPORT_ORDER_LOST_LIST.put("11", "������");
	// REPORT_ORDER_LOST_LIST.put("12", "�۸�");
	// REPORT_ORDER_LOST_LIST.put("13", "ԭ�׼�");
	// REPORT_ORDER_LOST_LIST.put("14", "�ܼ�");
	// REPORT_ORDER_LOST_LIST.put("15", "�����");
	// }

	public static final Map<String, String> getReportOrderLostList() {
		Map<String, String> REPORT_ORDER_LOST_LIST = new LinkedHashMap<String, String>();
		REPORT_ORDER_LOST_LIST.put("-1", "���");
		REPORT_ORDER_LOST_LIST.put("0", "������");
		REPORT_ORDER_LOST_LIST.put("1", "�����");
		REPORT_ORDER_LOST_LIST.put("2", "ISBN/ISSN");
		REPORT_ORDER_LOST_LIST.put("3", "����");
		REPORT_ORDER_LOST_LIST.put("4", "������");
		REPORT_ORDER_LOST_LIST.put("5", "��������");
		REPORT_ORDER_LOST_LIST.put("6", "�ֹݴ���");
		REPORT_ORDER_LOST_LIST.put("7", "���̴���");
		REPORT_ORDER_LOST_LIST.put("8", "Ԥ�����");
		REPORT_ORDER_LOST_LIST.put("9", "����ʱ��");
		REPORT_ORDER_LOST_LIST.put("10", "��������");
		REPORT_ORDER_LOST_LIST.put("11", "������");
		REPORT_ORDER_LOST_LIST.put("12", "�۸�");
		REPORT_ORDER_LOST_LIST.put("13", "ԭ�׼�");
		REPORT_ORDER_LOST_LIST.put("14", "�ܼ�");
		REPORT_ORDER_LOST_LIST.put("15", "�����");
		return REPORT_ORDER_LOST_LIST;
	}

	public static final String SERIES_REPORT_ACCEPT_ASK_NOT_IN_EXPORT_NAME = "δ�����ڿ�����";

	public static final String SERIES_REPORT_ACCEPT_ASK_NOT_HERE_EXPORT_NAME = "δ�����ڿ�����";

	// public static final Map<String, String> REPORT_ACCEPT_ASK_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_ACCEPT_ASK_LIST.put("-1", "���");
	// REPORT_ACCEPT_ASK_LIST.put("0", "������");
	// REPORT_ACCEPT_ASK_LIST.put("1", "ISBN/ISSN");
	// REPORT_ACCEPT_ASK_LIST.put("2", "����");
	// REPORT_ACCEPT_ASK_LIST.put("3", "������");
	// REPORT_ACCEPT_ASK_LIST.put("4", "��������");
	// REPORT_ACCEPT_ASK_LIST.put("5", "�ֹݴ���");
	// REPORT_ACCEPT_ASK_LIST.put("6", "���̴���");
	// REPORT_ACCEPT_ASK_LIST.put("7", "Ԥ�����");
	// REPORT_ACCEPT_ASK_LIST.put("8", "������");
	// REPORT_ACCEPT_ASK_LIST.put("9", "����ʱ��");
	// REPORT_ACCEPT_ASK_LIST.put("10", "δ������");
	// REPORT_ACCEPT_ASK_LIST.put("11", "����");
	// REPORT_ACCEPT_ASK_LIST.put("12", "����");
	// REPORT_ACCEPT_ASK_LIST.put("13", "Ԥ��");
	// }

	public static final Map<String, String> getReportAcceptAskList() {
		Map<String, String> REPORT_ACCEPT_ASK_LIST = new LinkedHashMap<String, String>();
		REPORT_ACCEPT_ASK_LIST.put("-1", "���");
		REPORT_ACCEPT_ASK_LIST.put("0", "������");
		REPORT_ACCEPT_ASK_LIST.put("1", "ISBN/ISSN");
		REPORT_ACCEPT_ASK_LIST.put("2", "����");
		REPORT_ACCEPT_ASK_LIST.put("3", "������");
		REPORT_ACCEPT_ASK_LIST.put("4", "��������");
		REPORT_ACCEPT_ASK_LIST.put("5", "�ֹݴ���");
		REPORT_ACCEPT_ASK_LIST.put("6", "���̴���");
		REPORT_ACCEPT_ASK_LIST.put("7", "Ԥ�����");
		REPORT_ACCEPT_ASK_LIST.put("8", "������");
		REPORT_ACCEPT_ASK_LIST.put("9", "����ʱ��");
		REPORT_ACCEPT_ASK_LIST.put("10", "δ������");
		REPORT_ACCEPT_ASK_LIST.put("11", "����");
		REPORT_ACCEPT_ASK_LIST.put("12", "����");
		REPORT_ACCEPT_ASK_LIST.put("13", "Ԥ��");
		return REPORT_ACCEPT_ASK_LIST;
	}

	public static final String SERIES_REPORT_ACCEPT_ARRIVE_EXPORT_NAME = "�ǵ�������";

	// public static final Map<String, String> REPORT_ACCEPT_ARRIVE_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_ACCEPT_ARRIVE_LIST.put("-1", "���");
	// REPORT_ACCEPT_ARRIVE_LIST.put("0", "������");
	// REPORT_ACCEPT_ARRIVE_LIST.put("1", "�ǵ���");
	// REPORT_ACCEPT_ARRIVE_LIST.put("2", "����");
	// REPORT_ACCEPT_ARRIVE_LIST.put("3", "ISBN/ISSN");
	// REPORT_ACCEPT_ARRIVE_LIST.put("4", "�ڿ���");
	// REPORT_ACCEPT_ARRIVE_LIST.put("5", "�������");
	// REPORT_ACCEPT_ARRIVE_LIST.put("6", "�����");
	// REPORT_ACCEPT_ARRIVE_LIST.put("7", "�ݲصص�");
	// REPORT_ACCEPT_ARRIVE_LIST.put("8", "����");
	// REPORT_ACCEPT_ARRIVE_LIST.put("9", "����");
	// REPORT_ACCEPT_ARRIVE_LIST.put("10", "������");
	// REPORT_ACCEPT_ARRIVE_LIST.put("11", "�ֹݴ���");
	// REPORT_ACCEPT_ARRIVE_LIST.put("12", "�ǵ�ʱ��");
	// }

	public static final Map<String, String> getReportAcceptArriveList() {
		Map<String, String> REPORT_ACCEPT_ARRIVE_LIST = new LinkedHashMap<String, String>();
		REPORT_ACCEPT_ARRIVE_LIST.put("-1", "���");
		REPORT_ACCEPT_ARRIVE_LIST.put("0", "������");
		REPORT_ACCEPT_ARRIVE_LIST.put("1", "�ǵ���");
		REPORT_ACCEPT_ARRIVE_LIST.put("2", "����");
		REPORT_ACCEPT_ARRIVE_LIST.put("3", "ISBN/ISSN");
		REPORT_ACCEPT_ARRIVE_LIST.put("4", "�ڿ���");
		REPORT_ACCEPT_ARRIVE_LIST.put("5", "�������");
		REPORT_ACCEPT_ARRIVE_LIST.put("6", "�����");
		REPORT_ACCEPT_ARRIVE_LIST.put("7", "�ݲصص�");
		REPORT_ACCEPT_ARRIVE_LIST.put("8", "����");
		REPORT_ACCEPT_ARRIVE_LIST.put("9", "����");
		REPORT_ACCEPT_ARRIVE_LIST.put("10", "������");
		REPORT_ACCEPT_ARRIVE_LIST.put("11", "�ֹݴ���");
		REPORT_ACCEPT_ARRIVE_LIST.put("12", "�ǵ�ʱ��");
		return REPORT_ACCEPT_ARRIVE_LIST;
	}

	// public static final Map<String, String> ALIGNMENTS = new
	// LinkedHashMap<String, String>();// ����ӡ���뷽ʽ
	// static {
	// ALIGNMENTS.put("left", "��");
	// ALIGNMENTS.put("center", "��");
	// ALIGNMENTS.put("right", "��");
	// }

	public static final Map<String, String> getAlignments() {
		Map<String, String> ALIGNMENTS = new LinkedHashMap<String, String>();
		ALIGNMENTS.put("left", "��");
		ALIGNMENTS.put("center", "��");
		ALIGNMENTS.put("right", "��");
		return ALIGNMENTS;
	}

	// public static final Map<String, String> FONT_TYPE = new
	// LinkedHashMap<String, String>();// ����ӡ��������
	// static {
	// FONT_TYPE.put("SimSun", "����");
	// FONT_TYPE.put("SimHei", "����");
	// FONT_TYPE.put("KaiTi", "����");
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
		FONT_TYPE.put("SimSun", "����");
		FONT_TYPE.put("SimHei", "����");
		FONT_TYPE.put("KaiTi", "����");
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
	// LinkedList<Integer>();// ����ӡ�����С
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
	// LinkedHashMap<String, String>();// ����ӡ����Ӵ�
	// static {
	// FONT_BOLD.put("normal", "����");
	// FONT_BOLD.put("bold", "�Ӵ�");
	// }

	public static final Map<String, String> getFontBold() {
		Map<String, String> FONT_BOLD = new LinkedHashMap<String, String>();
		FONT_BOLD.put("normal", "����");
		FONT_BOLD.put("bold", "�Ӵ�");
		return FONT_BOLD;
	}

	// public static final Map<String, String> SERIES_REPORT_BIND_ALL_SORT_WAY =
	// new LinkedHashMap<String, String>();// װ������������ʽ
	//
	// static {
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.orderNo", "������");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.title", "����");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.publisher", "������");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("bookSellerId", "����");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("batchNo", "װ������");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("bindDate", "װ��ʱ��");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("volInfo", "�����Ϣ");
	// SERIES_REPORT_BIND_ALL_SORT_WAY.put("callNo", "�����");
	// }

	public static final Map<String, String> getSeriesReportAllSortWay() {
		Map<String, String> SERIES_REPORT_BIND_ALL_SORT_WAY = new LinkedHashMap<String, String>();
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.orderNo", "������");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.isbn", "ISBN/ISSN");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.title", "����");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("biblioTemp.publisher", "������");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("bookSellerId", "����");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("batchNo", "װ������");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("bindDate", "װ��ʱ��");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("volInfo", "�����Ϣ");
		SERIES_REPORT_BIND_ALL_SORT_WAY.put("callNo", "�����");
		return SERIES_REPORT_BIND_ALL_SORT_WAY;
	}

	public static final String SERIES_REPORT_BIND_ALL_EXPORT_NAME = "װ��������";

	// public static final Map<String, String> REPORT_BINA_ALL_LIST = new
	// LinkedHashMap<String, String>();
	//
	// static {
	// REPORT_BINA_ALL_LIST.put("-1", "���");
	// REPORT_BINA_ALL_LIST.put("0", "�����");
	// REPORT_BINA_ALL_LIST.put("1", "ISBN/ISSN");
	// REPORT_BINA_ALL_LIST.put("2", "�����");
	// REPORT_BINA_ALL_LIST.put("3", "����");
	// REPORT_BINA_ALL_LIST.put("4", "������");
	// REPORT_BINA_ALL_LIST.put("5", "����Ϣ");
	// REPORT_BINA_ALL_LIST.put("6", "�ֹݴ���");
	// REPORT_BINA_ALL_LIST.put("7", "װ֡��ʽ");
	// REPORT_BINA_ALL_LIST.put("8", "װ����");
	// REPORT_BINA_ALL_LIST.put("9", "װ��ʱ��");
	// REPORT_BINA_ALL_LIST.put("10", "װ��״̬");
	// REPORT_BINA_ALL_LIST.put("11", "�ݲصص�");
	// REPORT_BINA_ALL_LIST.put("12", "�۸�");
	// REPORT_BINA_ALL_LIST.put("13", "����Ƶ��");
	// }

	public static final Map<String, String> getReportBindAllList() {
		Map<String, String> REPORT_BINA_ALL_LIST = new LinkedHashMap<String, String>();
		REPORT_BINA_ALL_LIST.put("-1", "���");
		REPORT_BINA_ALL_LIST.put("0", "�����");
		REPORT_BINA_ALL_LIST.put("1", "ISBN/ISSN");
		REPORT_BINA_ALL_LIST.put("2", "�����");
		REPORT_BINA_ALL_LIST.put("3", "����");
		REPORT_BINA_ALL_LIST.put("4", "������");
		REPORT_BINA_ALL_LIST.put("5", "����Ϣ");
		REPORT_BINA_ALL_LIST.put("6", "�ֹݴ���");
		REPORT_BINA_ALL_LIST.put("7", "װ֡��ʽ");
		REPORT_BINA_ALL_LIST.put("8", "װ����");
		REPORT_BINA_ALL_LIST.put("9", "װ��ʱ��");
		REPORT_BINA_ALL_LIST.put("10", "װ��״̬");
		REPORT_BINA_ALL_LIST.put("11", "�ݲصص�");
		REPORT_BINA_ALL_LIST.put("12", "�۸�");
		REPORT_BINA_ALL_LIST.put("13", "����Ƶ��");
		return REPORT_BINA_ALL_LIST;
	}

	public static final String SERIES_STATISTICS_ORDER_ALL_EXPORT_NAME = "����ͳ�Ʊ���";

	public static final String SERIES_STAISTICS_ORDER_NEW_EXPORT_NAME = "�¶�ͳ�Ʊ���";

	public static final String SERIES_STAISTICS_ORDER_STOP_EXPORT_NAME = "ͣ��ͳ�Ʊ���";

	public static final String SERIES_STATISTICS_ORDER_LOST_EXPORT_NAME = "©��ͳ�Ʊ���";

	public static final String SERIES_STATISTICS_ORDER_ARRIVE_EXPORT_NAME = "�ǵ�ͳ�Ʊ���";

	public static final String SERIES_STATISTICS_ORDER_BIND_ALL_NAME = "װ��ͳ�Ʊ���";

	// public static final Map<String, String> SERIES_STATISTICS_ORDER_ALL_LIST
	// = new LinkedHashMap<String, String>();
	//
	// static {
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("-1", "���");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("0", "�����");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("1", "����");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("2", "����");
	// SERIES_STATISTICS_ORDER_ALL_LIST.put("3", "�ܼ�");
	// }

	public static final Map<String, String> getSeriesStatisticsOrderAllList() {
		Map<String, String> SERIES_STATISTICS_ORDER_ALL_LIST = new LinkedHashMap<String, String>();
		SERIES_STATISTICS_ORDER_ALL_LIST.put("-1", "���");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("0", "�����");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("1", "����");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("2", "����");
		SERIES_STATISTICS_ORDER_ALL_LIST.put("3", "�ܼ�");
		return SERIES_STATISTICS_ORDER_ALL_LIST;
	}

	public static final String RENEW_SUCCESS = "renew_success"; // ����ɹ�

	public static final String LEND_DEAL_MAX = "lend_deal_max"; // ��������ѵ�

	public static final String LOSE_PENALTY = "lose_penalty"; // ���鷣��

	public static final String NO_LOSE = "no_lost";// �޷��

	public static final String BROKEN_PENALTY = "broken_penalty"; // ���𷣿�

	public static final String LEND_PENALTY = "lend_penalty"; // ���ڷ���

	public static final String WARN_BATCH_NOTREGIST = "regist_not_edit";// ��״̬�����޸�

	public static final String WARN_BATCH_EXISR_BIBLIOTEMP = "exist_biblio_temp";// �������Ѵ����ڿ�

	public static final String WARN_BATCH_NOT_FINISH = "warn_batch_not_finish";// ���״̬�������

	public static final Integer FINES_OVERDUE = 3; // �������ͣ����ڣ�

	public static final Integer FINES_BROKEN = 4; // �������ͣ�����

	public static final Integer FINES_LOST = 5; // �������ͣ���ʧ��

	public static final Integer PAY_TYPE_UNTREATED = 4; // ���ʽ��δ����

	public static final Integer PAY_TYPE_CASH = 1; // ���ʽ���ֽ�

	public static final Integer PAY_TYPE_ONECARD = 2;// ���ʽ��һ��ͨ��

	public static final Integer PAY_TYPE_CANCEL = 3;// ���ʽ��ȡ�����

	public static final Integer PAY_STATUS_ARREARAGE = 1;// �������ͣ�δ���

	public static final Integer PAY_STATUS_MADE = 2;// �������ͣ��Ѹ��

	public static final Integer PAY_STATUS_REFUND = 3;// �������ͣ��˿

	public static final String CAPTCHA_CAPTCHACODE = "/captcha/captchaCode";// ��ȡ��֤���·��

	public static final String MANAGER_OUT = "/manegerOut";// ��ȡ��֤���·��

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// �ŵ�session�е�key(��֤��)

	public static final Integer LOGIN_FAIL_MAX_TIME = 3;// ����ʧ�ܵĴ���

	public static final String LOGIN_ERROR_INFO_CAPTCHA = "��֤�����!";// ��֤�����

	public static final String SERIES_BATCH_SEND_SUCCESS = "series_batch_send_success";// �������ͳɹ�

	public static final Integer INIT_READER_UPLOAD_STARTROWNUM = 1; // Ĭ�ϵ��뿪ʼ����

	public static final String INIT_PATH_SERIESCYCLE = "InitSeriesCycle.xml";

	public static final String INIT_DATA_SERIESCYCLE = "/SeriesCycles/SeriesCycle";// ��ʼ�����ݵ�ʱ��
																					// �������ڵ�
																					// xml����

	public static final String INIT_PATH_SERIESCURRENCY = "InitSeriesCurrency.xml";

	public static final String INIT_DATA_SERIESCURRENCY = "/SeriesCurrencys/SeriesCurrency";// ��ʼ�����ݵ�ʱ��
																							// xml����
																							// ���ҹ���

	public static final String INIT_PATH_ROLE = "InitRole.xml";

	public static final String INIT_DATA_ROLE = "/roles/role";

	public static final Integer SEARCH_ABLE = 1; // ���ü�����ʶ

	public static final int INIT_SERIES_TYPE = 1;// �ڿ� ���ĳ�ʼ��ֵ

	public static final String WARN_RELATED_DATA = "warn_related_data";// �й�������,����ɾ��

	public static final Integer SEARCH_ENABLE = 2; // �����ü�����ʶ

	public static final Integer SEARCHMODE_FUZZY = 1; // ģ����ѯ

	public static final Integer SEARCHMODE_PRECISE = 2; // ��ȷ��ѯ

	public static final String COLLECTIONPLACE_NOT_NULL = "collectionPlace_not_null"; // �ݲصز���Ϊ��

	public static final String EXIST_BARCODE = "exist_barcode";// �Ѿ����ڵ�����

	public static final String SUCCESS_BARCODE = "success_barcode";// �ɹ���ݲص�����

	public static final String BARCODE_SHOW_TOKEN = "show_token";// ����ҳ��ˢ��
																	// ��ֹ�ύtoken

	public static final String READERLENDRULE_EXIST = "readerlendrule_exist"; // ���Ĺ����Ѵ��ڣ��޷��½������޸Ķ�Ӧ�Ľ��Ĺ���

	public static final Integer NOT_IN_COLLECTION = 1; // ���ڹݱ�ʶ

	public static final String WARN_BOOKLENDDETAIL_NOT_NULL = "warn_booklenddetail_not_null"; // ���׽����嵥,����������Ϊ��ʱ����ʾ��

	public static final String GZ_SERVER = "z39.91marc.cn";// ����z3950��������ַ

	public static final String WARN_LENDDETAIL_NOT_NULL = "warn_lenddetail_not_null";// ������ϸ�嵥,����������Ϊ��ʱ����ʾ��

	public static final String WARN_LENDDETAIL_NOT_EXIST = "warn_lenddetail_not_exist"; // ������ϸ�嵥,���������벻����ʱ����ʾ��

	public static final String WARN_BOOKLENDDETAIL_NOT_EXIST = "warn_booklenddetail_not_exist"; // ���׽����嵥,���������벻����ʱ����ʾ��

	// public static final List<String> CALLNO_FILTER_LIST = new
	// LinkedList<String>();// ����Ź����б�
	//
	// static {
	// // ����������ԭ����ԭ���� �� ������ ����д��������ѡ�ࡢ�ıࡢ ���롢 �롢��ע��ע�롢��ͼ����׫��׫�ġ�ͼ����ע������
	// CALLNO_FILTER_LIST.add("����");
	// CALLNO_FILTER_LIST.add("ԭ��");
	// CALLNO_FILTER_LIST.add("ԭ��");
	// CALLNO_FILTER_LIST.add("����");
	// CALLNO_FILTER_LIST.add("��д");
	// CALLNO_FILTER_LIST.add("����");
	// CALLNO_FILTER_LIST.add("ѡ��");
	// CALLNO_FILTER_LIST.add("�ı�");
	// CALLNO_FILTER_LIST.add("����");
	// CALLNO_FILTER_LIST.add("��ע");
	// CALLNO_FILTER_LIST.add("ע��");
	// CALLNO_FILTER_LIST.add("��ͼ");
	// CALLNO_FILTER_LIST.add("׫��");
	// CALLNO_FILTER_LIST.add("��ע");
	// CALLNO_FILTER_LIST.add("����");
	// CALLNO_FILTER_LIST.add("��");
	// CALLNO_FILTER_LIST.add("��");
	// CALLNO_FILTER_LIST.add("��");
	// CALLNO_FILTER_LIST.add("ͼ");
	// CALLNO_FILTER_LIST.add("׫");
	// }

	public static final List<String> getCallNoFilterList() {
		List<String> CALLNO_FILTER_LIST = new LinkedList<String>();
		CALLNO_FILTER_LIST.add("����");
		CALLNO_FILTER_LIST.add("ԭ��");
		CALLNO_FILTER_LIST.add("ԭ��");
		CALLNO_FILTER_LIST.add("����");
		CALLNO_FILTER_LIST.add("��д");
		CALLNO_FILTER_LIST.add("����");
		CALLNO_FILTER_LIST.add("ѡ��");
		CALLNO_FILTER_LIST.add("�ı�");
		CALLNO_FILTER_LIST.add("����");
		CALLNO_FILTER_LIST.add("��ע");
		CALLNO_FILTER_LIST.add("ע��");
		CALLNO_FILTER_LIST.add("��ͼ");
		CALLNO_FILTER_LIST.add("׫��");
		CALLNO_FILTER_LIST.add("��ע");
		CALLNO_FILTER_LIST.add("����");
		CALLNO_FILTER_LIST.add("��");
		CALLNO_FILTER_LIST.add("��");
		CALLNO_FILTER_LIST.add("��");
		CALLNO_FILTER_LIST.add("ͼ");
		CALLNO_FILTER_LIST.add("׫");
		return CALLNO_FILTER_LIST;
	}

	// public static final List<String> CALLNO_SIGN_LIST = new
	// LinkedList<String>();// ����ŷ��Ź���
	// static {
	// CALLNO_SIGN_LIST.add("��");
	// CALLNO_SIGN_LIST.add(",");
	// CALLNO_SIGN_LIST.add("��");
	// CALLNO_SIGN_LIST.add("/");
	// CALLNO_SIGN_LIST.add(" ");
	// }

	public static final List<String> getCallNoSignList() {
		List<String> CALLNO_SIGN_LIST = new LinkedList<String>();
		CALLNO_SIGN_LIST.add("��");
		CALLNO_SIGN_LIST.add(",");
		CALLNO_SIGN_LIST.add("��");
		CALLNO_SIGN_LIST.add("/");
		CALLNO_SIGN_LIST.add(" ");
		return CALLNO_SIGN_LIST;
	}

	// public static final Map<String, String> BOOKMARKSUBSTR = new
	// HashMap<String, String>();
	// static {
	// BOOKMARKSUBSTR.put("", "ȡȫ��");
	// BOOKMARKSUBSTR.put("before", "�ָ���ǰ");
	// BOOKMARKSUBSTR.put("after", "�ָ�����");
	// }

	public static final Map<String, String> getBookMarkSubStr() {
		Map<String, String> BOOKMARKSUBSTR = new HashMap<String, String>();
		BOOKMARKSUBSTR.put("", "ȡȫ��");
		BOOKMARKSUBSTR.put("before", "�ָ���ǰ");
		BOOKMARKSUBSTR.put("after", "�ָ�����");
		return BOOKMARKSUBSTR;
	}

	public static final String BOOKMARKSUBSTRBEFORE = "before";

	public static final String BOOKMARKSUBSTRAFTER = "after";

	public static final Integer CATALOGBOOKMARK = 1;// ��Ŀ����ӡ

	public static final Integer SERIESBOOKMARK = 2;// �ڿ�����ӡ

	public static final Integer BINDBOOKMARK = 3;// װ������ӡ

	// public static final List<String> ISBN_FILTER_LIST = new
	// LinkedList<String>();// isbn���Զ��ָ���ȡ����
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
	// DESK_RESOURCES.add("ͼ������");
	// DESK_RESOURCES.add("��Ŀά��");
	// DESK_RESOURCES.add("�ݲ�״̬����");
	// DESK_RESOURCES.add("�ݲر��");
	// DESK_RESOURCES.add("����");
	// DESK_RESOURCES.add("����");
	// DESK_RESOURCES.add("������Ϣ����");
	// DESK_RESOURCES.add("�ѻ��軹����");
	// DESK_RESOURCES.add("�ѻ���ͨ����");
	// }

	public static final List<String> getDeskResource() {
		List<String> DESK_RESOURCES = new LinkedList<String>();
		DESK_RESOURCES.add("��Ŀά��");
		DESK_RESOURCES.add("ͼ������");
		DESK_RESOURCES.add("����");
		DESK_RESOURCES.add("����");
		DESK_RESOURCES.add("�ѻ��軹����");
		DESK_RESOURCES.add("�ѻ���ͨ����");
		DESK_RESOURCES.add("������Ϣ����");
		DESK_RESOURCES.add("�ݲ�״̬����");
		DESK_RESOURCES.add("�ݲر��");
		DESK_RESOURCES.add("��������");
		return DESK_RESOURCES;
	}

	public static final String MAIN_PAGE_LINK_NAME = "�ɱ����";// ϵͳ��ҳ���ӵ�һ����Դ��

	public static final String OFFLINECIRCUL = "/offlineCircul/OfflineCircul.zip";// �ѻ��ļ����ص�·��

	public static final String OPERATIONTYPER = "r";// ��������r ����

	public static final String OPERATIONTYPEL = "l";// ��������l ����

	public static final String DATE_NOT_NULL = "date_not_null";// ���ڲ���Ϊ��

	public static final String SEARCH_PARAMETER_NOT_EXIST = "search_parameter_not_exist"; // ��������������

	public static final Integer INIT_BOOKNUM = 10; // ��ʼ�����׽������а�ͳ�Ʋ���

	public static final Integer CARD_MANAGER = 44; // ֤����״̬����

	public static final String READER_IS_NOT_SINLGE = "reader_is_not_sinlge"; // ��ѡ��һ������

	public static final String EXEC_SUCCESS = "exec_success"; // ����ɹ�

	// public static final List<String> IP_NO_LIMIT_LOCATION = new
	// ArrayList<String>();// ���Ե����ip����
	// static {
	// IP_NO_LIMIT_LOCATION.add("������");
	//
	// }

	public static final List<String> getIpNoLimitLocation() {
		List<String> IP_NO_LIMIT_LOCATION = new ArrayList<String>();
		IP_NO_LIMIT_LOCATION.add("������");
		return IP_NO_LIMIT_LOCATION;
	}

	// public static final List<String> IP_NO_LIMIT = new ArrayList<String>();//
	// ���ý����жϵ�ip
	// static {
	// IP_NO_LIMIT.add("������ַ���ڱ��ػ���");
	// IP_NO_LIMIT.add("������");
	// }

	public static final List<String> getIpNoLimit() {
		List<String> IP_NO_LIMIT = new ArrayList<String>();
		IP_NO_LIMIT.add("������ַ���ڱ��ػ���");
		IP_NO_LIMIT.add("������");
		return IP_NO_LIMIT;
	}

	// public static final List<String> IP_LIMIT_TYPE = new
	// ArrayList<String>();// �����ܹ�����
	// static {
	// IP_LIMIT_TYPE.add("����");
	// IP_LIMIT_TYPE.add("�ƶ�");
	// }

	public static final List<String> getIpLimitType() {
		List<String> IP_LIMIT_TYPE = new ArrayList<String>();
		IP_LIMIT_TYPE.add("����");
		IP_LIMIT_TYPE.add("�ƶ�");
		return IP_LIMIT_TYPE;
	}

	public static final String QQWRY_DAT_PATH = "QQWRY";// ip���ݿ��ļ�

	public static final String QQWARY_DAT_NAME = "qqwry.dat";// ���ݿ��ļ�����

	public static final String ERROR_IP_LIMIT = "IP����";// ip������

	public static final String ERROR_ACTIVE_CODE_PAST_DUE = "�������Ѿ�����";

	public static final String READER_LEND_RULE_NOT_EXIST = "reader_lend_rule_not_exist"; // ���Ĺ��򲻴��ڣ���������

	public static final Integer COLLECTION_DELETED = 2; // �ݲ���ɾ״̬

	public static final String COLLECTION_DELETED_WARN = "collection_deleted_warn"; // ��ɾ������ʾ

	public static final String READER_ID = "reader_id"; // ����Id session

	public static final String OVERDUE_SUCCESS = "overdue_success"; // �߻��ɹ�

	public static final String OVERDUE_ALL_SUCCESS = "overdue_all_success"; // �߻������嵥�ɹ�

	// public static final Map<Integer, String> SERIESACCEPTSTATUS = new
	// HashMap<Integer, String>();// �ǵ�״̬ת��
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

	public static final String SYS_MASSAGE_MIDDLE = ">Ӧ������Ϊ"; // ������Ϣ������

	public static final String SYS_MASSAGE_FOOT = "���뼰ʱ�黹��ͼ��ݣ�"; // ������Ϣ���ͽ�

	public static final Integer SYS_MESSAGE_STATUS_ENEXEC = 1;// ������Ϣ����״̬δ��

	public static final Integer SYS_MESSAGE_STATUS_EXEC = 2;// ������Ϣ����״̬�Ѷ�

	public static final Integer SYS_MESSAGE_STATUS = 45;// ������Ϣ����״̬

	public static final String SYS_MASSAGE_TITLE = "ͼ��ݴ߻�֪ͨ��";// ������Ϣ����Ĭ�ϱ���

	public static final String LEND_OVER_DUE = "lend_over_due";// ������ͼ����ڣ����Ȼ���

	public static final String NO_TYPE_FOR_SEARCH = "no_type_for_search";// ���ϸ������ļ�¼������

	public static final Double READERSTAT_INIT_ARREARAGE = (double) 0;// ��ʼ�������˻����

	public static final Integer FINES_EXECED = 2; // �Ѵ���

	public static final Integer FINES_UNEXECED = 1; // δ����

	public static final Integer FEE_TYPE_KEY = 46; // ����ģʽ��ֵ

	public static final Integer DEAL_STATUS_KEY = 47; // ����ģʽ��ֵ

	public static final String PAY_FOR_IC = "pay_for_ic"; // IC����ɹ�

	public static final String PAY_FOR_LATER = "pay_for_later"; // �Ժ󸶿�ɹ�

	public static final String PAY_FOR_CASH = "pay_for_cash"; // �ֽ𸶿�ɹ�

	public static final String PAY_FOR_CANCEL = "pay_for_cancel"; // ȡ������ɹ�

	public static final String LOSE_FIND = "lose_find"; // �����һسɹ�

	public static final String READERSTAT_ARREARAGE_OUT = "readerstat_arrearage_out"; // �����з���δ�������Ƚ��ɷ���

	public static final Integer FEE_TYPE_OVERDUE = 3; // ������ͨͼ�鳬��

	public static final Integer FEE_TYPE_BROKEN = 4; // ������ͨͼ������

	public static final Integer FEE_TYPE_LOSE = 5; // ������ͨͼ�鶪ʧ

	public static final Integer DEAL_STATUS_FIND_BACK = 3; // �����һ�

	public static final String ONE_RECORD_LIMIT = "one_record_limit"; // ��ѡ������һ����¼

	// public static final Map<String, String> readerTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// readerTitle.put("0", "���");
	// readerTitle.put("1", "��֯����");
	// readerTitle.put("2", "����֤��");
	// readerTitle.put("3", "����");
	// readerTitle.put("4", "�Ա�");
	// readerTitle.put("5", "��ʦ");
	// readerTitle.put("6", "״̬");
	// readerTitle.put("7", "����ʱ��");
	// readerTitle.put("8", "��ֹʱ��");
	// }

	public static final Map<String, String> getReaderTitle() {
		Map<String, String> readerTitle = new LinkedHashMap<String, String>();
		readerTitle.put("0", "���");
		readerTitle.put("1", "��֯����");
		readerTitle.put("2", "����֤��");
		readerTitle.put("3", "����");
		readerTitle.put("4", "�Ա�");
		readerTitle.put("5", "��ʦ");
		readerTitle.put("6", "״̬");
		readerTitle.put("7", "����ʱ��");
		readerTitle.put("8", "��ֹʱ��");
		return readerTitle;
	}

	public static final String READER_EXPORT_NAME = "�����嵥";// �����嵥��������

	public static final Map<String, String> circulateDetailTitle = new LinkedHashMap<String, String>();
	static {
		circulateDetailTitle.put("0", "���");
		circulateDetailTitle.put("1", "����");
		circulateDetailTitle.put("2", "����֤��");
		circulateDetailTitle.put("3", "����");
		circulateDetailTitle.put("4", "�����");
		circulateDetailTitle.put("5", "�ݲصص�");
		circulateDetailTitle.put("6", "��ͨ����");
		circulateDetailTitle.put("7", "�����");
		circulateDetailTitle.put("8", "�����Ϣ");
		circulateDetailTitle.put("9", "����");
		circulateDetailTitle.put("10", "��������");
		circulateDetailTitle.put("11", "��������");
		circulateDetailTitle.put("12", "��������");
		circulateDetailTitle.put("13", "״̬");
		circulateDetailTitle.put("14", "�������");
	}

	public static final String CIRCULATE_DETAIL_EXPORT_NAME = "������ʷ��ͨ�嵥";// ������ʷ��ͨ�嵥��������

	public static final String BOOK_CIRCULATE_DETAIL_EXPORT_NAME = "������ʷ���Ĳ�ѯ";// ������ʷ���Ĳ�ѯ�嵥��������

	// public static final Map<String, String> readerLendRankingTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// readerLendRankingTitle.put("0", "���");
	// readerLendRankingTitle.put("1", "����");
	// readerLendRankingTitle.put("2", "����֤��");
	// readerLendRankingTitle.put("3", "������֯");
	// readerLendRankingTitle.put("4", "��������");
	// readerLendRankingTitle.put("5", "���Ĵ���");
	// }

	public static final Map<String, String> getReaderRankinhgTitle() {
		Map<String, String> readerLendRankingTitle = new LinkedHashMap<String, String>();
		readerLendRankingTitle.put("0", "���");
		readerLendRankingTitle.put("1", "����");
		readerLendRankingTitle.put("2", "����֤��");
		readerLendRankingTitle.put("3", "������֯");
		readerLendRankingTitle.put("4", "��������");
		readerLendRankingTitle.put("5", "���Ĵ���");
		return readerLendRankingTitle;
	}

	public static final String READER_LEND_RANKING_EXPORT_NAME = "���߽������а�";// ���߽������а��嵥��������

	// public static final Map<String, String> bookCirculateRankingTitle = new
	// LinkedHashMap<String, String>();
	// static {
	// bookCirculateRankingTitle.put("0", "���");
	// bookCirculateRankingTitle.put("1", "����");
	// bookCirculateRankingTitle.put("2", "����");
	// bookCirculateRankingTitle.put("3", "�����");
	// bookCirculateRankingTitle.put("4", "����ʱ��");
	// bookCirculateRankingTitle.put("5", "���Ĵ���");
	// }

	public static final Map<String, String> getBookCirculateRanking() {
		Map<String, String> bookCirculateRankingTitle = new LinkedHashMap<String, String>();
		bookCirculateRankingTitle.put("0", "���");
		bookCirculateRankingTitle.put("1", "����");
		bookCirculateRankingTitle.put("2", "����");
		bookCirculateRankingTitle.put("3", "�����");
		bookCirculateRankingTitle.put("4", "����ʱ��");
		bookCirculateRankingTitle.put("5", "���Ĵ���");
		return bookCirculateRankingTitle;
	}

	public static final String BOOK_CIRCULATE_RANKING_EXPORT_NAME = "���׽������а�";// ���߽������а��嵥��������

	public static final String WARN_SYSDATA = "warn_sysDate";// ϵͳ���������������

	public static final String READER_TYPE_EXIST = "reader_type_exist";// ������ͨ���ʹ��벻���ظ�

	public static final String SAVA_SUCCESS = "sava_success";// ���ݱ���ɹ�

	public static final String SCHOOL_DEPT_EXIST = "school_dept_exist";// ��֯���벻���ظ�

	public static final String READER_EXIST = "reader_exist";// �������벻���ظ�

	public static final String READER_PECCANCY_OUT = "reader_peccancy_out";// ���ܳ������Υ�����

	public static final String WARN_COLLECTIONPLACE_EXIST = "warn_collectionplace_exist";// �ݲصش�����ʾ

	// public static final Map<String, String> LOGIC = new HashMap<String,
	// String>();// webopacҳ����߼���ϵ
	// static {
	// LOGIC.put("��", "and");
	// LOGIC.put("��", "or");
	// }

	public static final Map<String, String> getLogic() {
		Map<String, String> LOGIC = new HashMap<String, String>();
		LOGIC.put("��", "and");
		LOGIC.put("��", "or");
		return LOGIC;
	}

	// public static final Map<String, String> WO_QUERY_FIELD = new
	// HashMap<String, String>();// webopac��ѯ���ֶ�
	// static {
	// WO_QUERY_FIELD.put("����", "title");
	// WO_QUERY_FIELD.put("ISBN/ISSN", "isbn");
	// WO_QUERY_FIELD.put("����", "author");
	// WO_QUERY_FIELD.put("�����", "class_no");
	// WO_QUERY_FIELD.put("������", "publisher");
	// }

	public static final Map<String, String> getWoQueryField() {
		Map<String, String> WO_QUERY_FIELD = new HashMap<String, String>();
		WO_QUERY_FIELD.put("����", "title");
		WO_QUERY_FIELD.put("ISBN/ISSN", "isbn");
		WO_QUERY_FIELD.put("����", "author");
		WO_QUERY_FIELD.put("�����", "class_no");
		WO_QUERY_FIELD.put("������", "publisher");
		return WO_QUERY_FIELD;
	}

	// public static final Map<String, String> WO_SORT_FIELD = new
	// HashMap<String, String>();// webopac�����ֶ�
	// static {
	// WO_SORT_FIELD.put("--Ĭ��--", "id");
	// WO_SORT_FIELD.put("����", "author");
	// WO_SORT_FIELD.put("����ʱ��", "publisher");
	// }

	public static final Map<String, String> getWoSortField() {
		Map<String, String> WO_SORT_FIELD = new HashMap<String, String>();
		WO_SORT_FIELD.put("--Ĭ��--", "id");
		WO_SORT_FIELD.put("����", "author");
		WO_SORT_FIELD.put("����ʱ��", "publisher");
		return WO_SORT_FIELD;
	}

	public static final String WARN_SYSROLE_EXIST = "warn_sysrole_exist";// ��ɫ������ʾ

	public static final String WARN_CURRENT_VERSION = "warn_current_version";// ��ǰ��β�����ɾ��

	public static final Integer ONE_CARD_NAME = 48; // һ��ͨ�����б�

	public static final Integer ZYTK_VERSION = 49; // ��Ԫһ��ͨ�汾��

	// public static final List<String> ZYTK_VERSION_RESOURCES = new
	// ArrayList<String>();// ��Ԫ�ǻ�һ��ͨ�汾��
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
	// ArrayList<String>();// УѶͨ�汾��
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
	// RESOURCE_OPERRATE_LIST.add("����");
	// RESOURCE_OPERRATE_LIST.add("����");
	// RESOURCE_OPERRATE_LIST.add("����");
	// RESOURCE_OPERRATE_LIST.add("Ƿ�����");
	// RESOURCE_OPERRATE_LIST.add("����Ա����");
	// RESOURCE_OPERRATE_LIST.add("��ɫ����");
	// RESOURCE_OPERRATE_LIST.add("ѧУ����");
	// }

	public static final List<String> getResourceOperateList() {
		List<String> RESOURCE_OPERRATE_LIST = new LinkedList<String>();
		RESOURCE_OPERRATE_LIST.add("����");
		RESOURCE_OPERRATE_LIST.add("����");
		RESOURCE_OPERRATE_LIST.add("����");
		RESOURCE_OPERRATE_LIST.add("Ƿ�����");
		// RESOURCE_OPERRATE_LIST.add("����Ա����");
		// RESOURCE_OPERRATE_LIST.add("��ɫ����");
		// RESOURCE_OPERRATE_LIST.add("ѧУ����");
		return RESOURCE_OPERRATE_LIST;
	}

	public static final int CALLNO_TYPE = 217;// ��������������ֵ�ֵ

	public static final int PINYIN = 1;// �����ƴ�����ɷ�ʽ

	public static final int FOUR_CORNER_NUMBER = 2;// ������ĽǺ������ɷ�ʽ

	public static final int SEQUENCE = 3;// ������ִκ����ɷ�ʽ

	public static final int FOUR_CORNER_NUMBER_NAME_TYPE = 218;// �ĽǺ����Ӧ�������������ֵ�ֵ

	public static final int SINGLE_FAMILY_SINGLE_NAME = 1;// ���յ���

	public static final int SINGLE_FAMILY_DOUBLE_NAME = 2;// ����˫��

	public static final int DOUBLE_FAMILY_SINGLE_NAME = 3;// ˫�յ���

	public static final int DOUBLE_FAMILY_DOUBLE_NAME = 4;// ˫��˫��

	public static final int SUPER_FAMILY_SUPER_NAME = 5;// ��������(4������)

	public static final String SMS_PRICE_PATH = "SmsPrice.xml";

	public static final String SMS_PRICE_DATA = "/SmsPrices/SmsPrice";

	public static final String APPLE_SUCCESS = "apple_success";// ��������ɹ�

	public static final String WARN_AUDIT = "warn_audit";// ��˴�����ʾ

	public static final String SUCCESS_AUDIT = "success_audit";// ���ͨ��

	public static final String SOAP_SERIVCE = "ThirdWebservice";// webservice��һ������--һ��ͨ

	public static final String SOAP_PORT = "ThirdWebserviceSoap";// webservice�����ʵ����--һ��ͨ

	public static final String SOAP_TARGETNAMESPACE = "http://www.hzsun.com/";// wsdl��namespace
																				// Ҳ����wsdl��id----һ��ͨ

	public static final String SOAP_SECURITY_HEARDER = "SecurityHeader";// ����soapЭ��

	public static final String SUCCESS_SYNC = "success_sync";// ͬ���ɹ�

	public static final String WARN_SYNC = "warn_sync";// ͬ������

	public static final String WARN_SIGNIN = "warn_signin";// ����ǩ��

	public static final String SUCCESS_SIGNIN = "success_signin";// ǩ���ɹ�

	public static final int ADD_SOURCE_TYPE = 219;// MARC�ֶ�ģ�������Ƿ��������Դ�����ֵ�����

	public static final int PAY_STATUS_DIC_TYPE = 220;// ֧��״̬�����ֵ�����

	public static final int PAY_TYPE_DIC_TYPE = 221;// ������������

	public static final int CATALOGUE_DIC_TYPE = 222;// ��Ŀ���������ֵ�����

	public static final int EASY_CATALOGUE = 1;// �򵥱�Ŀ

	public static final int DETAIL_CATALOGUE = 2;// ��ϸ��Ŀ

	public static final int FEE_TYPE_DIC_TYPE = 223;// �������������ֵ�����

	public static final int IS_CANCEL_FEE = 1;// �����һ�ȡ������

	public static final int SPECIAL_TYPE_DIC_TYPE = 225;// ������������ר�����������ֵ�����

	public static final Map<String, String> DATAMANAGE = new HashMap<String, String>();

	public static final String COUNT_MANAGER_NAME = "ͳ�ƹ���";// ����ͳ������ͳ�ƹ���

	public static final Object ACTIVE_ERROR = "active.error";

	public static final Object ACTIVE_SUCCESS = "active.success";

	public static final int SCHOOL_USER_STOP_DIC_TYPE = 224;// ѧУ�û�ͣ�ñ�־�����ֵ�����

	public static final int SCHOOL_USER_NO_STOP = 1;// ѧУ�û�����

	public static final int SCHOOL_USER_IS_STOP = 2;// ѧУ�û�ͣ��

	public static final int READ_PARAM_FEE_DIC_TYPE = 226;// ���������շ����������ֵ�����

	public static final int READ_PLACE_DIC_TYPE = 227;// ���������������ֵ�����

	public static final int READ_REGIST_COUNT_SORT_DIC_TYPE = 228;// �����Ǽ�ͳ�����������ֵ�����

	public static final int READ_REGIST_COUNT_SORT_BY_MAX_NUM = 1;// �������������

	public static final int READ_REGIST_COUNT_SORT_BY_MAX_TIME = 2;// ��ʱ���������

	public static final String ERROR_READ_REGIST_COLLECTION_PLACE_NOT_FOUND = "Error.readRegist.collectionPlace.notFound";// ��Ӧ������û�в�������

	public static final String ERROR_READ_REGIST_READER_TYPE_NOT_FOUND = "Error.readRegist.readerType.notFound";// ��Ӧ��������û�в�������

	public static final String ERROR_READ_REGIST_BEYOND_FREE_TIME = "Error.readRegist.beyond.free.time";// �����������ʱ��

	public static final String ERROR_READ_REGIST_IS_ANCIENT_PLACE = "Error.readRegist.is.ancient.place";// ���ڹż�������

	public static final String ERROR_READ_REGIST_NO_IN = "Error.readRegist.no.in";// �ö���δ���������Ҵ�����ʾ

	public static final String SUCCESS_READ_REGIST_IN = "Success.readRegist.regist.in";// �����Ǽǵ���ɹ���ʾ

	public static final String SUCCESS_READ_REGIST_OUT = "Success.readRegist.regist.out";// �����Ǽǵǳ��ɹ���ʾ

	public static final String ERROR_READR_EGIST_IS_IN = "Error.readRegist.is.in";// �����Ѿ���������

	public static final String ERROR_READ_REGIST_HAS_IN = "Error.readRegist.hasReader.in";// �������ж�����δ�ǳ�

	public static final String ERROR_READ_PLACE_SEAT_IS_FULL = "Error.readPlaceSet.is.full";// �����Ǽ���λ������ʾ

	public static final int READER_CARD_TYPE_NOMAL = 1;// ���߿���������ͨ��

	public static final int READER_CARD_TYPE_VIP = 2;// ���߿�������VIP��

	public static final int READ_IS_FREE = 1;// �������������������

	public static final int CLOUD_MANAGER_STATUS_DIC = 229;// �ƶ�ά������״̬

	// ��ϸ��Ŀmarc��Ҫ�ֶ�

	public static final String MARC_049 = "049";// ��ĿԱ����

	public static final String MARC_090 = "090";// δ֪�����

	public static final String MARC_091 = "091";// ͳһ�鿯��

	public static final String MARC_205 = "205";// ���

	public static final String MARC_207 = "207";// ������������ڱ��

	public static final String MARC_300 = "300";// һ���Ը�ע

	public static final String MARC_327 = "327";// ���ݸ�ע

	public static final String MARC_345 = "345"; // �ɷ���ע

	public static final String MARC_410 = "410";// �Ա�

	public static final String MARC_411 = "411";// �ӴԱ�

	public static final String MARC_461 = "461";// �ܼ�

	public static final String MARC_462 = "462";// �ּ�

	public static final String MARC_500 = "500"; // ͳһ����

	public static final String MARC_510 = "510"; // ��������

	public static final String MARC_512 = "512"; // ��������

	public static final String MARC_516 = "516"; // �鼮����

	public static final String MARC_517 = "517"; // ��������

	public static final String MARC_540 = "540"; // ��Ŀ��Ա����ĸ�������

	public static final String MARC_600 = "600"; // ������������

	public static final String MARC_601 = "601"; // ������������

	public static final String MARC_605 = "605"; // ��������

	public static final String MARC_607 = "607"; // ��������

	public static final String MARC_610 = "610"; // �ǿ������

	public static final String MARC_686 = "686"; // �������෨���

	public static final String MARC_692 = "692"; // �й���ѧԺͼ���ͼ������

	public static final String MARC_702 = "702"; // ��������-��Ҫ������

	public static final String MARC_711 = "711"; // �������ƣ���һ������

	public static final String MARC_712 = "712"; // �������ƣ���Ҫ������

	public static final String MARC_730 = "730"; // �ǹ淶������

}
