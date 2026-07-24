class Solution {
    public int calPoints(String[] operations) {
          ArrayList<Integer> list = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int size = list.size();
                int a = list.get(size - 1);
                int b = list.get(size - 2);
                list.add(a + b);
            } else if (op.equals("D")) {
                int last = list.get(list.size() - 1);
                list.add(2 * last);
            } else if (op.equals("C")) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.parseInt(op)); 
            }
        }

        int sum = 0;
        for (int score : list) {
            sum += score;
        }

        return sum;
    }
}