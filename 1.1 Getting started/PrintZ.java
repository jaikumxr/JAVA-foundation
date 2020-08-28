public class PrintZ {
    public static void main(final String[] args) {
        int i,j;
        for(i=0;i<5;i++){
            if(i==0 || i==4){
                System.out.println("*****");
            } else {
                for(j=0;j<4-i;j++){
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }
}