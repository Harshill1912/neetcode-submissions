class MedianFinder {
PriorityQueue<Integer> pq;
    public MedianFinder() {
        pq=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
    }
    
    public double findMedian() {
        ArrayList<Integer> list=new ArrayList<>();

        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

      for(int i=0;i<list.size();i++) pq.offer(list.get(i));

      boolean even=true;
      if(list.size() % 2 == 1) even=false;

      if(even){
     double a = list.get((list.size() / 2) - 1); 
    double b = list.get(list.size() / 2); 

        return (a+b)/2.0;
      }

      return list.get(list.size()/2);
    }
}
