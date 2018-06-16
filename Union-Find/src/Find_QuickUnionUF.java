public class Find_QuickUnionUF 
{
	private int[] id;
	private int[] sz;
	private int[] max;
	
	public Find_QuickUnionUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		max = new int[N];
		
		for (int i = 0; i<N; i++)
		{
			id[i] = i;
			sz[i] = 1;
			max[i] = i;
		}
		
	}
	
	public int root(int p)
	{
		while(p != id[p])
		{
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if(i == j)
			return;
		
		if(sz[i] >= sz[j])
		{
			//root will be i
			id[j] = i;
			sz[i] = sz[i] + sz[j];
			if(max[j]>max[i])
				max[i] = max[j];
		}
		else
		{
			//root will be j
			id[i] = j;
			sz[j] = sz[i] + sz[j];
			if(max[i]>max[j])
				max[j] = max[i];
		}
	}
	
	public int find(int p)
	{
		return max[root(p)];
	}
}