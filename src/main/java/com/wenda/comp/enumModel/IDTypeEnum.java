package com.wenda.comp.enumModel;
/**
 * ʶ������
 * @author jinzhaopo
 *
 */
public enum IDTypeEnum {
	�ʺ�("1"),//�ʺ�
	����("2"),//����
	���ڱ��("3"),//���ڱ��
	���˱��("4"),//���˱��
	�������ԽӺ�("5");//�������ԽӺ�
	
	private String key;

	private IDTypeEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	
	
}
