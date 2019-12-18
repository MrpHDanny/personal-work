import net.dv8tion.jda.core.entities.MessageChannel;

public class RandomNumberGenerator {

    RandomNumberGenerator(MessageChannel channel){
    this.channel=channel;
    }
    private MessageChannel channel;
    private double randomDouble=0;
    private int randomInt=0;

    public void getExplanation(){
        channel.sendMessage("To use the command type in: ``!rng <Integer Number>``").queue();
    }

    public void runCommand(String arguments){
        try {
            int range = Integer.parseInt(arguments.trim());
            channel.sendMessage("" + generateNumber(range)).queue();
        }
        catch (NumberFormatException ex){
            channel.sendMessage("Invalid input").queue();
        }
    }

    public int generateNumber(int range){
        this.randomDouble = Math.random();
        this.randomDouble = this.randomDouble * range + 1;
        this.randomInt = (int) randomDouble;
        return randomInt;
    }



}
