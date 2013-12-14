import java.util.ArrayList;


public class BTree {

	/**
	 * Variable declaration
	 */
	int childcount, keycount;
	int[] valueArray;
	int[] keyArray;
	BTree[] childArray;
	int max;
	
	/**
	 * Constructor
	 * @param order
	 */
	public BTree(int order)
	{	
		
		int m1=order;
		keycount=0;
		childcount=0;
		if (m1%2!=0)
			{m1=m1-1;}
		max=m1;
		this.keyArray=new int[max+1];
		this.valueArray=new int[max+1];
		this.childArray=new BTree[max+2];
	}
	
	/**
	 * Search using values. 
	 * Searches in the Node first, using the by calling the ScanValue Array function
	 * If Node has a child then search in child.
	 * @param n
	 */
	public void BTreeSearch(int n)
	{
		int i=scanKeyArray(n);									//Find position
		if(i<keycount && keyArray[i]==n)				    	//return keycount							
			return;
		else if(childcount>0)
			childArray[i].BTreeSearch(n);						//Search in child
		
		else System.out.println("Not Found");					//Not found
		
	}
	
	/**
	 * Scan the data Array 'key[]' to find at which position should the new data be insertedReturn position
	 * @param n
	 * @return
	 */
	private int scanKeyArray(int n)
	{
		for (int i=0;i<keycount;i++)
			if (keyArray[i]>=n)
				return i;
		
		return keycount;		
	}
	
	
	
	/**
	 * Insert new data 'n','v' in the array at position 'in'. 
	 * Find the index, move all the previously inserted keys from position 'in' ahead by 1.
	 * Insert the data 'n','v' at position 'in'.
	 * @param in
	 * @param n
	 */
	private void insertKey(int in, int n, int v)         
	{
		for(int i=keycount;i>in;i--)
			{
			keyArray[i]=keyArray[i-1]; 					//Shift right
			valueArray[i]=valueArray[i-1];
			}
			
		keyArray[in]=n;
		valueArray[in]=v;								//Add new key
		keycount++;
	}
	
	
	/**
	 * Insert new child 'n' in the array at position 'in'.
	 * Find the position, move all the previously inserted Btrees from position 'in' ahead by 1.
	 * Insert the Btree 'n' at position 'in'.
	 * @param in
	 * @param b
	 */
	private void insertChild(int in,BTree b)
	{
		for(int i=childcount;i>in;i--)
			childArray[i]=childArray[i-1];				//Shift right
		childArray[in]=b;								//Add new child
		childcount++;							
	}
	
	
	/**
	 * Split function.
	 * Find the middle element 'mid'. And split the NodeArray using 'mid'.
	 * Copy the split array into a new Node 'newNode' of type 'Btree'. Insert corresponding child elements with it
	 * Update keycount and childcount
	 * @param i
	 */
	private void split(int i)
	{	
		if((childArray[i].keycount)%2!=0)
		{
			int x1=childArray[i].keycount/2;
			int x2=childArray[i].childcount/2;
			int mid=childArray[i].keyArray[childArray[i].keycount/2];									//Split the node at mid
			int midv=childArray[i].valueArray[childArray[i].keycount/2];
			
			BTree splitNode=new BTree(max);																//New node created to store split data 
			for(int j=x1+1;j<=2*x1;j++)
				splitNode.keyArray[j-x1-1]=childArray[i].keyArray[j];
			for(int j=x1+1;j<=2*x1;j++)
				splitNode.valueArray[j-x1-1]=childArray[i].valueArray[j];											
			for(int j=x2;j<2*x2;j++)
				splitNode.childArray[j-x2]=childArray[i].childArray[j];								//Copy it's respective childArray 
			
			childArray[i].keycount=x1;																//Update Values' count of original child
			childArray[i].childcount=x2;															//Update it's child count
			splitNode.keycount=x1;																	//Set new node's value count
			splitNode.childcount=x2;																//Set new node's child count	
			
			int temp=scanKeyArray(mid);																	//Insert the 'mid' node into it's parent
			insertKey(temp,mid,midv);					
			insertChild(i+1, splitNode);
		}
	}
	
	
	/**
	 * Add the new key 'n' directly in the node without caring about the maximum limit.
	 * First scan the NodeArray to find the position of the new node, then add the node in that place
	 * If the NodeArray has children, then scan the child array to insert the new Node.
	 * @param n
	 */
	public void preInsert(int n, int v) 
	{
		int in=scanKeyArray(n);						//Scan array to find position to insert 'n' using scanArray function	
		if(childcount>0)							//If node has a child, then insert in it's child node
		{
			childArray[in].preInsert(n, v);
			if(childArray[in].keycount>max)			//Child is full so split
				split(in);
		}
		
		else insertKey(in,n,v);						//No children so insert in node itself	
	}
	
	
	/**
	 * The Basic Insert function. This funcyion insert the value in the tree. 
	 * If the NodeArray is full, then it splits the NodeArray by calling the split function.
	 * @param value
	 */
	public void BTreeInsert(int key, int value)
	{
		preInsert(key, value);												//Simple insert
		
		if(keycount>max)													//Check if it has max values
		{
			BTree newNode=new BTree(max);						
			newNode.keycount=keycount;
			newNode.childcount=childcount;
			
			System.arraycopy(this.valueArray, 0, newNode.valueArray, 0, keycount);
			System.arraycopy(this.keyArray, 0, newNode.keyArray, 0, keycount);
			System.arraycopy(this.childArray,0,newNode.childArray,0,childcount);
			
			this.keycount=0;
			this.childcount=1;
			childArray[0]=newNode;
			split(0);
		}
	}	
		
	/**
	* Outputs the Btree level by level
	*/
	public void LevelOut1(ArrayList[] alevel, int level)
	{
		int i;
		level++;
		for(i=0;i<keycount;i++)
			alevel[level].add(valueArray[i]);
		
		for(i=0;i<childcount;i++)
			childArray[i].LevelOut1(alevel,level);
	}	
	
	public void LevelOut(ArrayList[] alevel, int level)
	{
		LevelOut1(alevel,-1);
		for(int i=0;i<20;i++)
		{
			if(alevel[i]!=null)
			{Dictionary.BTreeLo.println();
				for (int j=0;j<alevel[i].size();j++)
					Dictionary.BTreeLo.printf(alevel[i].get(j)+" ");}
		}
	
	}
	
	public void LevelOut1h(ArrayList[][] alevel1, int level1,int hashcode)
	{
		int i;
		level1++;
		for(i=0;i<keycount;i++)
			alevel1[hashcode][level1].add(valueArray[i]);
		
		for(i=0;i<childcount;i++)
			childArray[i].LevelOut1h(alevel1,level1,hashcode);
	}	
	
	public void LevelOuth(ArrayList[][] alevel1, int level1, int hashcode)
	{
		LevelOut1h(alevel1,-1,hashcode);

		for(int i=0;i<20;i++)
		{	
			if(alevel1[hashcode][i]!=null)
				{Dictionary.BTreehashLo.println();
				for (int j=0;j<alevel1[hashcode][i].size();j++)
					 Dictionary.BTreehashLo.printf(alevel1[hashcode][i].get(j)+" ");}
		}
	
	}
}
