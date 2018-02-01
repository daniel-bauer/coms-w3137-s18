public class Hanoi {


    public static int solve(int ndisks, String source, String help, String target) {        
        if (ndisks > 0) {
            int r1steps = solve(ndisks-1,source,target,help);
            System.out.println("Move "+source+" to "+target);
            int r2steps = solve(ndisks-1,help,source,target);
            return r1steps + r2steps + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] argv){
        int total_steps = solve(7,"A","B","C");            
        System.out.println(total_steps);
    }

}
