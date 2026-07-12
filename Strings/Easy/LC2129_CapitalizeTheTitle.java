package Strings.Easy;

public class LC2129_CapitalizeTheTitle {


    public static String capitalizeTitle(String title) {

        String words[]=title.split(" ");
        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<words.length;i++){

            String word=words[i].toLowerCase();

            if(word.length()>2){

                char first=Character.toUpperCase(word.charAt(0));
                sb.append(first);
                sb.append(word.substring(1));

            }else{
                sb.append(word);
            }
            if(i<words.length-1){
                sb.append(" ");
            }
        }
    return sb.toString();


    }
    
    public static void main(String[] args) {
       String title = "capiTalIze tHe titLe";
       System.out.println(capitalizeTitle(title));
    }
}
