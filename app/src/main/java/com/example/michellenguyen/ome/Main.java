
public class Main {

	public static void main(String[] args) {
		//GroupTest();
		//GroupFuncTest();
		PaymentTest();
	}
	
	public static void GroupTest(){
		Group testGroup = new Group();
		System.out.println(testGroup.getGroupID());
		System.out.println(testGroup.getGroupName());
	}
	
	public static void GroupFuncTest(){
		Member PaulChen = new Member("Paul Chen", 3., 1);
		Member SteakChan = new Member("Kristine Nguyen", 100, 0);
		Group test = new Group("Doot Doot", PaulChen);
		test.addMember(SteakChan);
		System.out.println(test.getGroupName());
		System.out.println(test.setGroupName("Tood Tood", SteakChan));
		System.out.println(test.setGroupName("Tood Tood", PaulChen));
		System.out.println(test.getGroupName());
		System.out.println(test.getMember(PaulChen.getID()).getName());
	}
	
	public static void PaymentTest(){
		Member Admin = new Member("Admin", 100, 1);
		Member User = new Member("User", 50, 0);
		Group test = new Group("Test Group", Admin);
		System.out.println(test.addPayment(Admin, User, 25));
		
		
	}

}
