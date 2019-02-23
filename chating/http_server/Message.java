package liao_tianV3;

public class Message {
	
	private String TYPE_B="*";
	private String RECEIVER_B="@";
	private String SENDER_B="$";
	private String CONTENT_B="\r\n";
	static final String TYPE_LOGIN="Type_login";
	static final String TYPE_SINGLE="Type_single";
	static final String TYPE_GROUP="Type_group";
	public String getType(String msg)
	{
		String type=msg.substring(0, msg.indexOf(TYPE_B));
		return type;
	}
	
	public String getReceiver(String msg)
	{
		String receiver=msg.substring(msg.indexOf(TYPE_B)+1, msg.indexOf(RECEIVER_B));
		return receiver;
	}
	
	public String getSender(String msg)
	{
		String sender=msg.substring(msg.indexOf(RECEIVER_B)+1, msg.indexOf(SENDER_B));
		return sender;
	}
	
	public String getContent(String msg)
	{
		String content=msg.substring(msg.indexOf(SENDER_B)+1, msg.indexOf(CONTENT_B));
		return content;
	}

//	public static void main(String[] args)
//	{
//		Message m = new Message();
//		String mm="Type_login*user1@sen$nihao\r\n";
//		System.out.println(m.getContent(mm));
//		System.out.println(m.getType(mm));
//		System.out.println(m.getReceiver(mm));
//		System.out.println(m.getSender(mm));
//	}
}
