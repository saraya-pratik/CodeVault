class Router{
    int n;
    Queue<int[]> q=new LinkedList<>();
    HashSet<String> hs=new HashSet<>();
    Map<Integer,List<int[]>> prefix=new HashMap<>();
    Map<Integer,Integer> startIndex=new HashMap<>();

    public Router(int memoryLimit){
        this.n=memoryLimit;
    }

    public boolean addPacket(int source,int destination,int timestamp){
        String s=source+","+destination+","+timestamp;
        if(hs.contains(s))return false;
        if(q.size()==n)forwardPacket();
        int[] pkt=new int[]{source,destination,timestamp};
        q.add(pkt);
        hs.add(s);
        prefix.putIfAbsent(destination,new ArrayList<>());
        startIndex.putIfAbsent(destination,0);
        List<int[]> arr=prefix.get(destination);
        int prevCount=arr.isEmpty()?0:arr.get(arr.size()-1)[1];
        arr.add(new int[]{timestamp,prevCount+1});
        return true;
    }

    public int[] forwardPacket(){
        if(q.isEmpty())return new int[]{};
        int[] pkt=q.poll();
        String s=pkt[0]+","+pkt[1]+","+pkt[2];
        hs.remove(s);
        List<int[]> arr=prefix.get(pkt[1]);
        int idx=startIndex.get(pkt[1]);
        if(idx<arr.size()&&arr.get(idx)[0]==pkt[2])startIndex.put(pkt[1],idx+1);
        return pkt;
    }

    public int getCount(int destination,int startTime,int endTime){
        if(!prefix.containsKey(destination))return 0;
        List<int[]> arr=prefix.get(destination);
        int idxStart=startIndex.get(destination);
        if(idxStart>=arr.size())return 0;
        int l=idxStart,r=arr.size()-1,left=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr.get(m)[0]>=startTime){left=m;r=m-1;}else l=m+1;
        }
        if(left==-1)left=arr.size();
        l=idxStart;r=arr.size()-1;int right=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr.get(m)[0]<=endTime){right=m;l=m+1;}else r=m-1;
        }
        if(right==-1||left>right)return 0;
        int countLeft=left>0?arr.get(left-1)[1]:0;
        return arr.get(right)[1]-countLeft;
    }
}