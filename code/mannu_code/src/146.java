class MyNode {
	Object val;
	Object key;
	MyNode pre=null;
	MyNode next=null;
	MyNode(Object key,Object val){
		this.val=val;
		this.key=key;
	}

}
class DoubleLinkedList {
	private MyNode dummyHead=new MyNode(null,null);
	private MyNode tail=dummyHead;
	//添加元素到尾节点
	public void add(MyNode myNode){
		tail.next=myNode;
		myNode.pre=tail;
		tail=myNode;

	}
	//得到头节点
	public MyNode getHead(){
		return dummyHead.next;
	}
	//移除当前节点
	public void removeCurrNode(MyNode myNode){
		myNode.pre.next=myNode.next;
		//myNode.next前面节点的定义
		if(myNode.next!=null){
			myNode.next.pre=myNode.pre;
		}
		else{
			tail=myNode.next;
		}
		myNode.pre=null;
		myNode.next=null;
	}
	//移动当前节点到末尾
	public void moveToTail(MyNode myNode){
		removeCurrNode(myNode);
		add(myNode);

	}
}
public class LRUCache {
	private int capacity=0;
	private HashMap<Integer,MyNode> map=new HashMap<>();
	private DoubleLinkedList list=new DoubleLinkedList();
	public  LRUCache(int capacity){
		this.capacity=capacity;

	}
	//get的同时，将当前节点移动到末尾
	public int getNode(int key){
		if(map.containsKey(key)){
			return (int)map.get(key).val;
			list.moveToTail(map.get(key));

		}
		else{
			return -1;
		}

	}
	public void put(int key,int val){
		//
		if(map.containsKey(key)){
			list.moveToTail(map.get(key));
		}
		else{
			if(map.size()==capacity){
				MyNode head=list.getHead();
				list.removeCurrNode(head);
				MyNode newNode=new MyNode(key,val);
				list.add(newNode);
				map.put(key,newNode);
			}
			else{
				//直接添加
				MyNode newNode=new MyNode(key,val);
				list.add(newNode);
				map.put(key,newNode);

			}
		}

	}

}


