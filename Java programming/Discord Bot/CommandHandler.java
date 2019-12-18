import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

class CommandHandler {
    private MessageReceivedEvent event;
    private MessageChannel channel; // Channel in which the message was sent
    private String command; // The very first token of the message
    private String arguments; // Arguments ( tokens after the command )


    /* Receive messages from the EventListener and break them down
       Parameters: userMessage, channel, event
     */
    void receiver(String userMessage, MessageChannel channel, MessageReceivedEvent event){
    String[] contents = userMessage.split("\\s"); // Split message into tokens
    this.event=event;
    this.channel= channel; // Message channel
    this.command = contents[0].toLowerCase(); // First token
    this.arguments = userMessage.replace(command,""); // String of arguments
    runCommand();
    }

    /* Decide which command to run */
    private void runCommand(){
    switch(command){

        case "ping": ping(); break;
        case "help": help(); break;
        case "rng": RandomNumberGenerator rng = new RandomNumberGenerator(channel);
            if(arguments.isEmpty()) rng.getExplanation();
            else rng.runCommand(arguments);
            break;
    }
    }

    /* PING COMMAND */
    private void ping(){
        channel.sendMessage("Ping " + event.getJDA().getPing()).queue();
    }

    /* HELP COMMAND */
    private void help(){
            /*
            The following lines of code create an embedded message using the MessageBuilder
            .setColor sets the color of the strip on the left side of the message
            .setAuthor sets the icon and title of the message (See the actual message in discord to understand)
            .addField adds a new line to the message
            .build builds the message
            */
            channel.sendMessage(
                    new MessageBuilder()
                            .setEmbed(new EmbedBuilder()
                                    .setColor(new Color(15524437))

                                    .setThumbnail("https://cdn.discordapp.com/attachments/541340063498502178/541743485045178369/b1nzy.gif")
                                    .setAuthor("Command list for ʎuuɐp ɹW:", "https://twitter.com/pH1Danny", "https://cdn.discordapp.com/attachments/541340063498502178/543911568606232594/nanachi.jpg")
                                    .addField("Get help... No, seriously, get some help","``To get help with the commands just type them in without any arguments e.g !quote``",false)
                                    .addField("!rng <number>", "`Generate a random number between 1 and <number>`", false)
                                    .addField("!addquote <text> -<author>", "`Adds a quote to memory`", false)
                                    .addField("!quote", "`Returns a random quote from memory`", false)
                                    .addField("!encrypt <text> > <key> ", "`Encrypts your message using Caesar Cypher`", false)
                                    .addField("!isitaword <Word>", "`Tells you whether your work exists in the English dictionary`",false)
                                    .addField("!dance","`Would you like to dance with me?`",false)
                                    .build())
                            .build()).queue();
    }

}
