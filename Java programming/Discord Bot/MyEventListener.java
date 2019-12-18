import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MyEventListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String PREFIX = "!";
        CommandHandler handler = new CommandHandler();
        /* Ignore any messages sent by other bots */
        if (event.getAuthor().isBot())
            return;

        /* Grab the message */
        Message message = event.getMessage(); // Grab the message
        String userMessage = message.getContentRaw(); // Raw content of the message
        MessageChannel channel = event.getChannel(); // Grabs the channel the message was sent in

        if (userMessage.startsWith(PREFIX)) {
            userMessage = userMessage.substring(1); // Remove the PREFIX
            handler.receiver(userMessage, channel, event); // Send the message to CommandHandler
        }

        /*
         * WORK IN PROGRESS TRYING TO IMPLEMENT A COMMAND TO CHANGE PREFIX Won't work
         * unless is hosted live. Unless you store PREFIX in a file ??? Potential fix
         */
        if (userMessage.startsWith(PREFIX + "changeprefix")) {
            String[] contents = userMessage.split("\\s");
            channel.sendMessage(contents[1] + " " + contents[1].length()).queue();
            if (!contents[1].equals(null)) {
                channel.sendMessage("here").queue();
                String prefix = contents[1];
                if (prefix.length() < 1 || prefix.length() > 1) {
                    channel.sendMessage("Prefix must be one character long").queue();
                } else {
                    this.PREFIX = prefix;
                    channel.sendMessage("New prefix is set to " + PREFIX).queue();
                }
            }
        }

        /* The following code is commented out due to code refactoring */

        /* Simple commands that return a message to predefined user messages */
        //
        // if (userMessage.toLowerCase().startsWith("good night")) {
        // channel.sendMessage("Sleep tight!").queue();
        //
        // }
        //
        // if (userMessage.toLowerCase().startsWith("who is the greatest?")) {
        // channel.sendMessage(message.getAuthor().getAsMention() + " is the
        // greatest").queue();
        // }
        //
        // if (userMessage.toLowerCase().startsWith("hello")) {
        // channel.sendMessage("Hello " + message.getAuthor().getName() + " :wave:
        // ").queue();
        //
        // }
        //
        // /* Utility commands */
        //
        //
        //
        //
        // /* Quote commands */
        //
        // if (userMessage.toLowerCase().startsWith("!quote")) {
        // /*
        // Command is invoked by typing !quote without any arguments
        // Returns a randomly selected quote from Quotes.txt
        // */
        //
        // try {
        //
        // /*
        // The following lines of code open the Quotes.txt file and count the number of
        // lines in it
        // The number of quotes is stored in "numberOfQuotes" variable which is then
        // used to generate
        // A random integer in the range of 0 to "numberOfQuotes", thus picking a quote
        // at that line
        // */
        // RandomNumberGenerator generator = new RandomNumberGenerator();
        // int numberOfQuotes = 0; // Number of lines in Quotes.txt
        // int randomQuoteLine; // Stores a randomly selected line number
        // Scanner reader = new Scanner(new FileReader("E:\\UNIVERSITY\\Work
        // applications\\IntelliJ IDEA\\Projects\\MrDannyBot\\Quotes\\Quotes.txt"));
        //
        // while (reader.hasNextLine()) {
        // /*
        // Counts the number of lines or quotes
        // */
        // numberOfQuotes += 1;
        // reader.nextLine();
        // }
        //
        // randomQuoteLine = generator.generateNumber(numberOfQuotes); // Generates a
        // random int from 0 to "numberOfQuotes"
        // reader.close(); // Always close your readers, kids
        //
        // /*
        // The following lines of code open the Quotes.txt file and choose a quote at a
        // randomly selected line
        // The quote is stored in the "quote" variable.
        // */
        // String quote = ""; // Used to store a chosen quote from Quotes.txt
        //
        // Scanner selector = new Scanner(new FileReader("E:\\UNIVERSITY\\Work
        // applications\\IntelliJ IDEA\\Projects\\MrDannyBot\\Quotes\\Quotes.txt"));
        //
        // for (int i = 0; i < randomQuoteLine; i++) {
        // /*
        // Selects the quote at the randomly generated line
        // */
        // quote = selector.nextLine();
        // }
        //
        // selector.close(); // Always close your scanners, kids
        //
        // channel.sendMessage(quote).queue(); // Returns a quote
        //
        // } catch (FileNotFoundException ex) {
        // /*
        // If the Quotes.txt file is not found return this
        // */
        // channel.sendMessage("Uh oh, the quotes file is missing!").queue();
        // channel.sendMessage("Make sure to tell Danny how silly he is...
        // :angry:").queue();
        // }
        //
        //
        // }
        //
        // if (userMessage.toLowerCase().startsWith("!addquote")) {
        // /*
        // Command is invoked by typing !addquote <Message> - <Author>
        // Stores the quote in Quotes.txt
        // */
        //
        // // If the user hasn't provided any arguments return how the command is meant
        // to be used
        // if (userMessage.endsWith("!addquote")) {
        // channel.sendMessage("To use the command type in: ``!quote <Message> -<Author>
        // ``").queue();
        // }
        //
        // userMessage = userMessage.substring(10); // Remove the !addquote from the
        // String
        //
        //
        // String[] line = userMessage.split("-"); // Splits the message using the
        // delimiter " - "
        //
        // /*
        // line[0] now contains the actual message
        // line[1] now contains the author of the message
        // */
        //
        // Quote quote = new Quote();
        //
        // try {
        //
        // quote.setQuote("\" " + line[0].trim() + "\" "); // Assigns contents of
        // line[0] as a quote
        // quote.setAuthor(line[1].replaceAll("\\s", "")); // Assigns contents of
        // line[1] as an author
        // quote.setDate(message.getCreationTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        // // Adds a date to the quote
        // channel.sendMessage("Quote added! :thumbsup: ").queue(); // Responds to user
        // if executed correctly
        //
        // } catch (ArrayIndexOutOfBoundsException ex) {
        // /*
        // If the user adds incorrect arguments send this
        // */
        // channel.sendMessage("Invalid format. Type in: ``!quote <Message> -<Author>
        // ``").queue();
        // }
        //
        // try {
        // /*
        // This try block assigns a writer to the Quotes.txt file and adds the quote,
        // author and date in a new line
        // */
        // BufferedWriter writer = new BufferedWriter(
        // new FileWriter("E:\\UNIVERSITY\\Work applications\\IntelliJ
        // IDEA\\Projects\\MrDannyBot\\Quotes\\Quotes.txt", true));
        // if ((quote.getAuthor() != null) && quote.getDate() != null) {
        // writer.write(quote.getQuote() + "-" + quote.getAuthor() + " - " +
        // quote.getDate() + "\r\n");
        // }
        // writer.close(); // Always close the writer, kids
        // } catch (FileNotFoundException e) {
        // /*
        // If Quotes.txt is not found or does not exist send this
        // */
        // channel.sendMessage("Uh oh, the quotes file is missing!").queue();
        // channel.sendMessage("Make sure to tell Danny how silly he is...
        // :angry:").queue();
        // } catch (IOException ex) {
        // /*
        // To be honest I don't know what this exception is for, but IntelliJ really
        // insisted
        // on adding it, and so I did.
        // */
        // channel.sendMessage("Uh oh, something is wrong with the quotes
        // file!").queue();
        // channel.sendMessage("Make sure to tell Danny how silly he is... :angry:
        // ").queue();
        // }
        // }
        //
        /* Random fun commands */

        // if (userMessage.toLowerCase().startsWith("!dance")){
        //
        //
        // String author = message.getAuthor().getAsMention();
        //
        // MessageBuilder buildMessage = new MessageBuilder();
        // EmbedBuilder embed = new EmbedBuilder();
        //
        //
        // File file = new File("E:\\UNIVERSITY\\Work applications\\IntelliJ
        // IDEA\\Projects\\MrDannyBot\\images\\dance");
        // File[] files = file.listFiles();
        // Random rand = new Random();
        // File image = files[rand.nextInt(files.length)];
        //
        //
        //
        // embed.setImage("attachment://" + image.getName())
        // .setDescription(author + " likes to dance!");
        // buildMessage.setEmbed(embed.build());
        //
        // channel.sendFile(image, image.getName(), buildMessage.build()).queue();
        //
        // }

        //
        // if (userMessage.toLowerCase().startsWith("!encrypt")) {
        // /*
        // Command is invoked by typing !encrypt <Message> > <key>
        // Returns an encrypted String (Using a crappy Caesar Cypher)
        // */
        //
        // /*
        // If the user hasn't provided any arguments return how the command is meant to
        // be used
        // */
        // if (userMessage.endsWith("!encrypt")) {
        // channel.sendMessage("This command encrypts your message using Caesar
        // Cypher.\n" +
        // "To encrypt your message use: ``!encrypt <Message> > <key>`` \n" +
        // "The <key> defines how much the code should be shifted.\n" +
        // "You can also use this command to decrypt a message if you know its key by
        // using the negative value of it\n\n" +
        // "An example of how to use the command: \n" +
        // "``!encrypt Hello > 1`` to encrypt message \n" +
        // "``!encrypt Jgnnq > -1`` to decrypt a message").queue();
        // }
        // try {
        // /*
        // Remove the "!encrypt" part and split the message into tokens
        // Assign tokens to appropriate variables
        // */
        // userMessage = userMessage.substring(9);
        // String[] line = userMessage.split(">");
        //
        // String messageToEncrypt = line[0]; // Message to encrypt
        // messageToEncrypt = messageToEncrypt.trim(); // Removes any whitespace at the
        // end of message
        //
        // String keyString = line[1]; // Key as a String
        // keyString = keyString.replaceAll("\\s", ""); // Replace all whitespace
        // int key = Integer.parseInt(keyString); // Parse key into an integer
        //
        // /*
        // Create the encryptor object which takes the following arguments: [ message ,
        // key ]
        // Send results back into the channel
        // */
        // CaesarCipher encryptor = new CaesarCipher(messageToEncrypt, key);
        // channel.sendMessage(encryptor.encryptMessage()).queue();
        //
        // } catch (ArrayIndexOutOfBoundsException ex) {
        // /*
        // If the command was incorrect return this
        // */
        // channel.sendMessage("Invalid format \nCorrect format: !encrypt <Message>
        // ><Key> ").queue();
        // } catch (NumberFormatException ex) {
        // /*
        // If user hasn't provided a correct number ( had non numerical characters )
        // return this
        // */
        // channel.sendMessage("Invalid format. Please don't use a space after the \">\"
        // symbol").queue();
        // }
        //
        //
        // }
        //
        // if (userMessage.toLowerCase().startsWith("!isitaword")){
        // /*
        // Command is invoked by typing !isitaword <Word>
        // Returns true or false message depending if <Word> is a word in the english
        // dictionary
        // */
        //
        // userMessage = userMessage.substring(10); // Remove the "!isitaword" part
        // String myWord = userMessage.replaceAll("\\s","").toLowerCase(); // myWord is
        // the <Word> argument
        //
        // /*
        // Create an array of words and populate it with words from a text file
        // */
        // ArrayList<String> words = new ArrayList<>();
        // String word;
        // try {
        // Scanner inFile = new Scanner(new FileReader("E:\\UNIVERSITY\\Eclipse
        // workspace\\MrDannyBot\\words_alpha.txt"));
        // while(inFile.hasNextLine()){
        // word = inFile.nextLine();
        // words.add(word);
        // }
        // /*
        // Compare myWord with every word in the file and set found to true if the word
        // exists in the dictionary
        // */
        // boolean found = false;
        //
        // for(int i=0;i<words.size();i++){
        // if(myWord.equals(words.get(i))) {
        // found = true;
        // }
        // }
        // /*
        // Return a message depending on the found variable
        // */
        // if(found == true){
        // channel.sendMessage("It is a word").queue();
        // } else channel.sendMessage("It's not a word").queue();
        // inFile.close();
        //
        //
        // }
        //
        // catch (FileNotFoundException ex){
        //
        // }
        // }

    }
}
