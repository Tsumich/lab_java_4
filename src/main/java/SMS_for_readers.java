public class SMS_for_readers {

    String tel_number;
    String message;

    public SMS_for_readers(String tel_number, String message) {
        this.tel_number = tel_number;
        this.message = message;
    }

    public void sendMessaege(){
        System.out.println("Отпралено на номер " + tel_number + " сообщение: "  + message);
    }
}
