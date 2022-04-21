package estrutura.de.dados;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Gibbet {

    private String word;
    private Integer lives;
    private Integer error;
    private String usedLetters = "";
    private CircularDoubleList list = new CircularDoubleList();

    public Gibbet(){}

    public Gibbet(String word){
        this.word = word;
    }

    public Gibbet(String word, Integer lives, String usedLetters) {
        this.word = word;
        this.lives = lives;
        this.usedLetters = usedLetters;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public String getUsedLetters() {
        return usedLetters;
    }

    public void setUsedLetters(String usedLetters) {
        this.usedLetters = usedLetters;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Gibbet{" +
                "word='" + word + '\'' +
                ", lives=" + lives +
                ", error=" + error +
                ", usedLetters='" + usedLetters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gibbet)) return false;
        Gibbet gibbet = (Gibbet) o;
        return Objects.equals(getWord(), gibbet.getWord()) && Objects.equals(getLives(), gibbet.getLives()) && Objects.equals(getError(), gibbet.getError()) && Objects.equals(getUsedLetters(), gibbet.getUsedLetters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), getLives(), getError(), getUsedLetters());
    }

    // Verifica se vence/ Retorna true se verdadeiro
    public boolean win(boolean x){
        return x;
    }

    // Mensagem winner
    public void winer(){
        System.out.println("Parabéns. Você venceu!!!");
    }

    /**
     *  Palavra vira lista duplamente encadeada circular
     * @param word palavra a aser transformada em lista
     * @return Retorna lista da palavra passada como parametro
     */
    public CircularDoubleList convertWordToChar(String word) {
        word = word.toUpperCase();
        String arr[] = word.split("");
        for (int i = 0; i < arr.length; i++) {
            list.addToTopOfList(arr[i]);
        }
        //list.showList2();
        return list;
    }

    /**
     * Captura uma letra de entrada do usuario
     * @return retorna letra capturada
     */
    public char inChar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Digite uma letra: ");
        char value = scanner.next().charAt(0);
        //char value2 = Character.toUpperCase(value);  //
        return Character.toUpperCase(value);
    }

    /**
     * BIEMVIDO AO JOGO DA FORCA
     */
    public void openGame(){
        System.out.println("\n#####################################################################");
        System.out.println("#               BIEMVIDO AO JOGO DA FORCA                           #");
        System.out.println("#####################################################################\n");
    }

    /**
     * Switch case desenho forca
     * @param op operação do status do desenho
     */
    public void forca(int op){
        switch (op){
            case 1:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||         (xx)      \n" +
                        "||       +++++++     \n" +
                        "||         */||/°    \n" +
                        "||          IL       \n" +
                        "---------------------\n" +
                        "####  ENFORCADO  ####\n");
                System.out.println(" Continue trinando! ");
                return;

            case 2:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||        */||/°     \n" +
                        "||          IL       \n" +
                        "---------------------\n");
                break;
            case 3:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||        */||       \n" +
                        "||          IL       \n" +
                        "---------------------\n");
                break;

            case 4:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||       */||        \n" +
                        "||          I        \n" +
                        "---------------------\n");
                break;

            case 5:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||        */||       \n" +
                        "||                   \n" +
                        "---------------------\n");
                break;


            case 6:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||          ||       \n" +
                        "||                   \n" +
                        "---------------------\n");
                break;


            case 7:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||        ('',)      \n" +
                        "||                   \n" +
                        "||                   \n" +
                        "||                   \n" +
                        "---------------------\n");
                break;

            case 8:
                System.out.println("          \n" +
                        "===========|*|       \n" +
                        "||         |*|       \n" +
                        "||                   \n" +
                        "||                   \n" +
                        "||                   \n" +
                        "---------------------\n");
                break;

        }

    }

    // Imprime primeira letra e o resto trçinhos
    public void showWord(CircularDoubleList l){
        char aux;
        //forca(0);
        System.out.print("\n" + l.getHead().getElement() );
        for (int i = 0; i < l.getCounter() - 1; i++){
            System.out.print(" _ ");
        }
        System.out.println();
        //System.out.println();
        //l.setAux(l.getHead());
        //do {
        //    aux = inChar();
        //    for (int i = 0; i < l.getCounter(); i++){
        //        if (l.getAux().getElement().equals(aux)){
        //            System.out.println( l.getHead().getElement() + " - "  );
        //        }
        //        l.setAux(l.getAux().getNext());
        //    }
//
        //    lives--;
        //}while (lives != 0);
    }


    public void run(CircularDoubleList l){
        int vidas = 8;
        int acertos = 0, erros = 0;
        int forca = 8;
        int aux = 0;
        Object auxInput;
        CircularDoubleList l2 = new CircularDoubleList();
        l2.addToTopOfList(l.getHead().getElement());

        forca(8);
        showWord(l);
        //System.out.println(" Letras usadas: " + getUsedLetters());

        do {


            auxInput = inChar();
            usedLetters = usedLetters + auxInput;
            usedLetters = usedLetters + " ";


            // se elemento existir na lista entra
            if (l.checksIfElementIsInTheList(auxInput)){

                aux = l.chesksIfElementIsInTheListII(auxInput);
                System.out.println("aux = l.chec ************************ " + aux);
                System.out.println("lives " + vidas);

                for (int i = 0; i < l.getCounter(); i++){
                    System.out.println("++++  dentro for antes do 2 if, i == aux: i= " + i);
                    System.out.println("lives " + vidas);
                    if (i == aux){

                        l2.addByIndexToList(auxInput,i);
                    }
                    else {
                        System.out.println("2° else ");
                        System.out.println("lives " + vidas);
                        l2.addByIndexToList(" _ ", i);
                    }
                }
                acertos++;
            }else{

                forca--;
                vidas--;
                erros++;
            }

            System.out.println("Letras usadas: " + getUsedLetters());
            forca(forca);

            //if (getUsedLetters().length() == l.getCounter() && lives > 0 ){
            //    winer();
            //}
            System.out.println("Acertos: " + acertos);
            System.out.println("Erros: " + erros);
            l2.showList2();
        }while (vidas != 0);
    }

    public void checks(CircularDoubleList l){
        int forca = 8;
        CircularDoubleList l2 = new CircularDoubleList();
        l2.addToTopOfList(l.getHead().getElement());

        forca(forca);
        l2.showList2();
        System.out.println();

        do{
            System.out.println("acabei de entrar no do" );
            for (int i = 0; i < l.getCounter(); i++){
                if (l.checksIfElementIsInTheList(inChar())){
                    l2.addByIndexToList(inChar(),i);
                    System.out.println("if" + i);
                }else {
                    l2.addByIndexToList(" _ ",i);

                    System.out.println("else " + i + " Lives: " + lives);
                }

                System.out.println("fora do if dentro do for" + i);
            }
            System.out.println("fora do for: ");
            usedLetters += inChar();
            System.out.println("Letras usadas: " + getUsedLetters());
            if (getUsedLetters().length() == l.getCounter()){
                win(true);
                winer();
            }
            forca--;
            lives--;
            System.out.println(" antes do tesete while =  Lives: " + lives);
        }while (lives != 0);
        System.out.println("fora do while: ");
        l2.showList2();
    }


    public void gamePlay(CircularDoubleList list){
        CircularDoubleList list2 = new CircularDoubleList();
        CircularDoubleList list3 = new CircularDoubleList();

        list3.addToTopOfList(list.getEnd().getElement());

        list.setAux(list.getHead());
        do {

            System.out.print(" " + list.getAux().getElement());
            list.setAux(list.getAux().getNext());


        }while (list.getAux() != list.getHead());

        list3.showList2();
    }

    // Abre lista de palavra txt
    public void readCsvFile() {
        String filename = "src\\estrutura\\de\\dados\\Words";
        String row;
        //Random random = new Random();
        //String aux = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                //aux = data[random.nextInt()];
                //Arrays.stream(data).forEach(System.out::println);
                //System.out.println("-----------------");
                //for (int i = 0; i < data.length; i ++){
                //    System.out.println(data[i]);
                //}
            }
        } catch (FileNotFoundException e) {
            // erro na abertura do arquivo
            System.out.println("Erro na abertura do arquivo");
        } catch (IOException e) {
            // erro na leitura do arquivo
            System.out.println("Erro na leitura do arquivo");
        }
        //return aux;
    }

    public void gameRun(){
        // lista com palavras
        String[] words = {"HOLA", "TODO","BIEN","calor",
                "formiga",
                "homem",
                "antifragil",
                "papai",
                "amor",
                "feliz",
                "sorte",
                "alegria",
                "amizade",
                "abcdefghijklmnñopqrstuvwxyz",};

        // Lista de letras usadas
        String usedLetters = "";

        // tamanho da lista/ counter
        int lengthWords = words.length;

        // Letra input do usuário
        char letter = 0;

        // Random gera num aleatório
        Random random = new Random();

        // Entrada input
        Scanner in = new Scanner(System.in);

        // Indice aleatório gerado pelo rando na escala que tenha na lista
        int indexRandom = random.nextInt(lengthWords);

        // Seleciona 1 palavra da lista/ escolhido aleatório pelo random acima
        String wordRandom = words[indexRandom].toUpperCase();

        // Lista de letras acertadas
        char[] hits = new char[wordRandom.length()];


        //wordRandom = readCsvFile();

        // Cria os traçinhos de letras ocultas/ anderline
        for (int i = 0; i < wordRandom.length(); i++){
            System.out.print(" _ ");
        }
        System.out.println();

        boolean win = false;
        int lives = wordRandom.length();

        do {
            System.out.println("\n" +
                    "Você tem: " + lives + " Vidas \n" +
                    "Letras utilizadas: " + usedLetters + " \n" +
                    "Digite letra: ");
            letter = in.next().toUpperCase().charAt(0);
            usedLetters += " " + letter;


            boolean minusLives = true;
            // Verifica se existe a letra na palavra
            for (int i = 0; i < wordRandom.length(); i++){
                if (letter == wordRandom.charAt(i)){
                    //System.out.println("Tem essa letra " + letter + " na posição " + i);
                    hits[i] = 1;
                    minusLives = false;
                }
            }

            if (minusLives){
                lives--;
            }

            // Imprime palavra sorteada da lista
            //System.out.println(wordRandom);


            // Cria os traçinhos de letras ocultas/ anderline
            for (int i = 0; i < wordRandom.length(); i++){

                if (hits[i] == 0){
                    System.out.print(" _ ");
                    win = false;
                }else{
                    System.out.print(" " +  wordRandom.charAt(i) + " " );
                }
            }
            System.out.println();

        }while (!win && lives > 0);

        if (lives != 0 ){
            System.out.println("\n  **** Você venceu! ****");
        }else{
            System.out.println("\n  ---- Você perdeu! ----" +
                    "\n   A palavra era: " + wordRandom);
        }
    }


    public static void main(String[] args){
        Gibbet f = new Gibbet();
        //f.convertWordToChar("Leonardo");
        //f.gamePlay(f.convertWordToChar("Leonardo"));
        //f.readCsvFile();
        f.gameRun();
        //f.showWord(f.convertWordToChar("Leonardo"));
        //f.showWord(f.convertWordToChar("Leonardo"));
        //f.forca(0);
        //System.out.println(f.inChar());
        //f.checks(f.convertWordToChar("Leonardo"));
        //f.run(f.convertWordToChar("Leonardo"));
    }
}
