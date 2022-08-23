//
//import java.util.Scanner;
//
///**
// * @author ll （ created: 2022-05-31 22:02 )
// */
//
//interface Discount{
//    int priceDiscount(int price);
//}
//
//interface Ticket{
//    String typeTicket();
//}
//
//class AdultDiscount implements Discount{
//    @Override
//    public int priceDiscount(int price) {
//        return price;
//    }
//}
//
//class ArmyDiscount implements Discount{
//    @Override
//    public int priceDiscount(int price) {
//        return 0;
//    }
//}
//
//class StudentDiscount implements Discount{
//    @Override
//    public int priceDiscount(int price) {
//        return (int) (0.8 * price);
//    }
//}
//
//class ChildDiscount implements Discount{
//
//    @Override
//    public int priceDiscount(int price) {
//        return price - 30;
//    }
//}
//
//class PaperTicket implements Ticket{
//
//    @Override
//    public String typeTicket() {
//        return "PaperTicket";
//    }
//}
//
//class electronicalTicket implements Ticket{
//
//    @Override
//    public String typeTicket() {
//        return "E_ticket";
//    }
//}
//
//class Park{
//    Discount discount;
//    Ticket ticket;
//
//    public Discount getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(Discount discount) {
//        this.discount = discount;
//    }
//
//    public Ticket getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Ticket ticket) {
//        this.ticket = ticket;
//    }
//
//    int ticketPrice(int price){
//        return getDiscount().priceDiscount(price);
//    }
//}
//public class Main {
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        String tmp = scanner.nextLine();
//        int price = Integer.parseInt(tmp);
//        int tickets = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < tickets; i++) {
//            String[] instr = scanner.nextLine().split(" ");
//            Park park = new Park();
//            switch (instr[0]) {
//                case "adult":
//                    park.setDiscount(new AdultDiscount());
//                    break;
//                case "student":
//                    park.setDiscount(new StudentDiscount());
//                    break;
//                case "soldier":
//                    park.setDiscount(new ArmyDiscount());
//                    break;
//                case "children":
//                    park.setDiscount(new ChildDiscount());
//                    break;
//            }
//            switch (instr[1]){
//                case "paper":
//                    park.setTicket(new PaperTicket());
//                    break;
//                case "electronical":
//                    park.setTicket(new electronicalTicket());
//                    break;
//            }
//            System.out.println(park.getTicket().typeTicket());
//            System.out.println("Price:" + park.ticketPrice(price));
//        }
//    }
//}
