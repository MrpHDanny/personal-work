import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;


public class Main {
// throws Exception
    public static void main(String[] args) {

        try {

            String token = "Removed for github";
            JDA builder = new JDABuilder(AccountType.BOT).setToken(token).build().awaitReady();
            builder.addEventListener(new MyEventListener());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
