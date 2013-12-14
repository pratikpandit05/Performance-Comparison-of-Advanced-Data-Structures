import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;


public class Dictionary {
	public static PrintWriter AVLIo;
	public static PrintWriter AVLPo;
	public static PrintWriter AVLhashIo;
	public static PrintWriter AVLhashPo;
	public static PrintWriter BTreeLo;
	public static PrintWriter BTreehashLo;
	public static ArrayList<Integer> asort=new ArrayList<Integer>();
	public static ArrayList[] alevel=new ArrayList[20];
	public static ArrayList[][] alevel1=new ArrayList[3][20];

	/**
	 * /*
	 * Main function. Program execution starts from here.
	 * It consists of two modes. Random mode and User Input mode.
	 * Random Mode:
	 * For AVL Tree, it inserts 1000000 nodes in the AVL tree using 'AVLInsert' function, and searches these 1000000 nodes using 'AVLSearch'
	 * Time is measured for the execution of these functions.
	 * For AVL Hash, it input 's' from the user, and creates an AVL Tree array of size 's'
	 * It then inserts 1000000 nodes into 's' AVL Trees using 'AVLInsert', and searches these 1000000 nodes using 'AVLSearch'.
	 * Time is measured for the execution of these functions.
	 * For RBHash, using the same 's' it creates TreeMap array of size 's'
	 * It then inserts 1000000 nodes into 's' RB Trees (TreeMap) using 'put', and searches these 1000000 nodes using 'get' function.
	 * Time is measured for the execution of these functions
	 * For BTree, it inputs 'order' from the user, and creates B-Tree of that order
	 * It inserts 1000000 nodes in the B-Tree using 'BTreeInsert' function, and searches these 1000000 nodes using 'BTreeSearch' function
	 * Time is measured for the execution of these functions
	 * For BTree Hash, using the same 's' it creates BTree array of size 's' 
	 * It then inserts 1000000 nodes into 's' BTrees using 'BTreeInsert', and searches these 1000000 nodes using 'BTreeSearch' function.
	 * 
	 * User Input Mode:
	 * It takes a <key,value> pair from the user and inserts it into AVL Tree, AVL Hash, Red Black Hash, B Tree and B Tree Hash.
	 * It prints sorted, level output from B Tree and inOrder, postOrder for AVL tree, AVL hash.
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException
	{	
		if (args[0].equals("-r"))
		{	
		System.out.println("Random mode started");
		
		//Initialize n
		int n=1000000;
		int s=Integer.parseInt(args[1]);
		int order=Integer.parseInt(args[2]);
		
		//Create instances of all trees
		AVL avltree=new AVL();										//AVL Instance
		Node node=null;												//AVL Node Instance
		AVLHash avlhash=new AVLHash();
		Node hashtable[]=new Node[s];								//AVL Hash Instance
		TreeMap<Integer, Integer> []tm = new TreeMap[s];			//RB Hash Instance
		for(int i=0;i<s;i++)										//RB Initialize
			tm[i]=new TreeMap();									//RB Initialize
		RBHash rbhash=new RBHash();										//RB Initialize
		BTree btree=new BTree(order);								//BTree Instance
		BTree btreeh[]=new BTree[s];								//BTree Instance
		for(int i=0;i<s;i++)										//BTree Initialize
			btreeh[i]=new BTree(order);						  		//BTree Initialize
		BTreeHash btreehash=new BTreeHash();						//BTreeHash Initialize
		
			
		//ArrayList to store 'n' nodes and randomize them 
		ArrayList<Integer> al=new ArrayList<Integer>();
		for (int i=1;i<=n;i++)
			al.add(i);
		Collections.shuffle(al);
		
		
		
		
		/**
		 * Calls AVLInsert and inserts 1000000 keys and values in AVLTree
		 */
		long start1=0;																	
		long stop1=0;
		start1 = System.currentTimeMillis();										//Time measurement started for AVLTree Insert
				
		for(int i=0;i<n;i++)
		{
			node=avltree.avlInsert(al.get(i),al.get(i)*2,node);						//Values inserted
		}
				
		stop1 = System.currentTimeMillis();											//Time measurement stopped for AVLTree Insert
		long timeInsert1 = stop1 - start1;
		System.out.println("AVL Tree- Time to insert   "+timeInsert1);				//Time Calculation
		
		
		long start2=0;
		long stop2=0;
		start2 = System.currentTimeMillis();										//Time measurement started for AVLTree Search
		for(int i=0;i<n;i++)
		{
			Node search=avltree.search(al.get(i), node);							//Values searched
		}
		stop2 = System.currentTimeMillis();											//Time measurement stopped for AVLTree Search
		long timeSearch2 = stop2 - start2;
		System.out.println("AVL Tree- Time to search   "+timeSearch2);
		
		
		
		
		
		
		
		//AVLHash Insert
		long start3=0;
		long stop3=0;
		start3 = System.currentTimeMillis();														//Time measurement started for AVLTree Hash Insert
		
		for(int i=0;i<n;i++)
		{
			int hashcode1=(al.get(i))%s;
			avlhash.AVLHashInsert(al.get(i),al.get(i)*2,hashtable,hashcode1);						//Values inserted
		}
		
		stop3 = System.currentTimeMillis();															//Time measurement stopped for AVLTree Hash Insert
		long timeInsert3 = stop3 - start3;
		System.out.println("AVL Hash- Time to insert   "+timeInsert3);
		
		//AVLHash Search
		long start4=0;
		long stop4=0;
		start4 = System.currentTimeMillis();														//Time measurement started for AVLTree Hash Search
		for(int i=0;i<n;i++)
		{
			int hashcode2=(al.get(i))%s;
			avlhash.AVLHashSearch(al.get(i),hashtable,hashcode2);									//Values searched
		}
		stop4 = System.currentTimeMillis();															//Time measurement stopped for AVLTree Hash Search
		long timeSearch4 = stop4 - start4;
		System.out.println("AVL Hash- Time to search   " +timeSearch4);
		
		
		
		
		
		
		//RB Insert
		long start5=0;
		long stop5=0;
		start5 = System.currentTimeMillis();											//Time measurement started for RB Hash Insert
		
		for(int i=0;i<n;i++)
		{
			int hashcode3=(al.get(i))%s;		
			rbhash.RBHashInsert(al.get(i),(al.get(i))*2,tm,hashcode3);					//Values Inserted
		}
		stop5 = System.currentTimeMillis();												//Time measurement stopped for RB Hash insert
		long timeInsert5= stop5 - start5;
		System.out.println("RB Tree - Time to insert   " + timeInsert5);
		
		//RB Search
		long start6=0;
		long stop6=0;
		start6 = System.currentTimeMillis();											//Time measurement started for RB Hash Search
		for(int i=0;i<n;i++)
		{
			int hashcode4=(al.get(i))%s;
			rbhash.RBHashSearch(al.get(i),tm,hashcode4);					//Values searched
		}
		stop6 = System.currentTimeMillis();												//Time measurement stopped for RB Hash Search
		long timeSearch6 = stop6 - start6;
		System.out.println("RB Tree - Time to search   " + timeSearch6);
		
		
		
		
		
		//BTree Insert
		long start7=0;
		long stop7=0;
		start7 = System.currentTimeMillis();											//Time measurement started for B Tree Insert
		for(int i=0;i<n;i++)															
		{
			btree.BTreeInsert(al.get(i),al.get(i)*2);									//Values Inserted
		}
		stop7 = System.currentTimeMillis();												//Time measurement stopped for B Tree Insert
		long timeInsert7 = stop7 - start7;
		System.out.println("B Tree  - Time to insert   " + timeInsert7);
		
		//BTree Search
		long start8=0;
		long stop8=0;
		start8 = System.currentTimeMillis();											//Time measurement started for B Tree Hash Insert
		for(int i=0;i<n;i++)
		{
			btree.BTreeSearch(al.get(i));												//Values searched
		}
		stop8 = System.currentTimeMillis();												//Time measurement stopped for B Tree Hash Insert
		long timeSearch8 = stop8 - start8;
		System.out.println("B Tree  - Time to search   " + timeSearch8);
		
		
		
		
		
		//BTree Hash
		long start9=0;
		long stop9=0;
		start9 = System.currentTimeMillis();											//Time measurement started for B Tree Hash Insert
		
		for(int i=0;i<n;i++)
		{
			int hashcode5=(al.get(i))%s;
			btreehash.BTreeHashInsert(al.get(i),al.get(i)*2,btreeh,hashcode5);					//Values Inserted
		
		}
		stop9 = System.currentTimeMillis();												//Time measurement stopped for B Tree Hash Insert
		long timeInsert9 = stop9 - start9;
		System.out.println("BTree Hash - Time to insert   " + timeInsert9);
		
		//BTree Hash Search
		long start10=0;
		long stop10=0;
		start10 = System.currentTimeMillis();											//Time measurement started for B Tree Hash Search
		
		for(int i=0;i<n;i++)
		{
			int hashcode6=(al.get(i))%s;
			btreehash.BTreeHashSearch(al.get(i),btreeh,hashcode6);  					//Values Search
		}
		stop10 = System.currentTimeMillis();											//Time measurement stopped for B Tree Hash Search
		long timeSearch10 = stop10 - start10;
		System.out.println("BTree Hash - Time to search   " + timeSearch10);
		
		
		}
		else if (args[0].equals("-u"))
		{
			System.out.println("User Mode");
			int s=3;
			int order=3;
			AVL avltree=new AVL();										//AVL Instance
			Node node=null;												//AVL Node Instance
			AVLHash avlhash=new AVLHash();								//AVL Hash Instance
			Node hashtable[]=new Node[s];								//AVL Hash Instance
			TreeMap<Integer, Integer> []tm = new TreeMap[s];			//RB Hash Instance
			for(int i=0;i<s;i++)										//RB Initialize
				tm[i]=new TreeMap();									//RB Initialize
			BTree btree=new BTree(order);								//BTree Instance
			BTree btreehash[]=new BTree[s];								//BTree Instance
			for(int i=0;i<s;i++)										//BTree Initialize
				btreehash[i]=new BTree(order);						  	//BTree Initialize
			
			AVLIo = new PrintWriter(new BufferedWriter(new FileWriter("AVL_inorder.out")), true);
			AVLPo = new PrintWriter(new BufferedWriter(new FileWriter("AVL_postorder.out")), true);
			AVLhashIo = new PrintWriter(new BufferedWriter(new FileWriter("AVLhash_inorder.out")), true);
			AVLhashPo = new PrintWriter(new BufferedWriter(new FileWriter("AVLhash_postorder.out")), true);
			BTreeLo = new PrintWriter(new BufferedWriter(new FileWriter("BTree_level.out")), true);
			BTreehashLo = new PrintWriter(new BufferedWriter(new FileWriter("BTreehash_level.out")), true);

			
			BufferedReader br = new BufferedReader(new FileReader(args[1]));			//Input the file from its location
			String[] stringArray=new String[2];
			String string = br.readLine();
			string=br.readLine();
																						//Line by line read
			
			while (string != null) 
			{
			stringArray = string.split(" ");											//Split into 'key' and 'value'
			try 
			{
			int key = Integer.parseInt(stringArray[0]);													//Save key						
			int value = Integer.parseInt(stringArray[1]);												//Save value

			node=avltree.avlInsert(key,value,node);														//Insert into AVLTree
			
			int hashcode1=(key)%s;
			avlhash.AVLHashInsert(key,value,hashtable,hashcode1);										//Insert into AVLHash
			
			btree.BTreeInsert(key,value);																//Insert into BTree
			
			int hashcode5=(key)%s;																		
			btreehash[hashcode5].BTreeInsert(key,value);												//Insert into BTree Hash
			//Insert into BTree Hash
			//System.out.println(key+"  "+value);
			string=br.readLine();
			} 
			catch (Exception e) {break;}
			
			}
			avltree.inOrder(node);																		//AVL Inorder 
			avltree.postOrder(node);																	//AVL PostOrder
			
			for (int i=0;i<s;i++)
			{
			Dictionary.AVLhashIo.println();	
			avltree.inOrderh(hashtable[i]);																//AVLHash Inorder
			Dictionary.AVLhashIo.println();
			Dictionary.AVLhashIo.println();
			}
			
			for (int i=0;i<s;i++)
			{
			Dictionary.AVLhashPo.println();
			avltree.postOrderh(hashtable[i]);															//AVL Postorder
			Dictionary.AVLhashPo.println();
			Dictionary.AVLhashPo.println();
			}
		
			for(int i=0;i<20;i++)
				alevel[i]=new ArrayList();
			btree.LevelOut(alevel,-1);																	//BTree Level Out
			
			for(int j=0;j<3;j++)
				for(int i=0;i<20;i++)
					alevel1[j][i]=new ArrayList();
			
			for (int i=0;i<s;i++)
			{
			Dictionary.BTreehashLo.println();
			btreehash[i].LevelOuth(alevel1,-1,i);															//BTree hash Level Out
	
			}
			
			
			}
			
			
			
		}
	}
	
	
