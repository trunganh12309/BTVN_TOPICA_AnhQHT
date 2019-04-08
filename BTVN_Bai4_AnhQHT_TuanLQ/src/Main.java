import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader abc = new BufferedReader(new FileReader("D:\\Download\\BTVN-Topica\\week-1\\b4_raw.txt"))){
            String s;
            List<String> data = new ArrayList<>();

            while((s=abc.readLine())!=null) {
                Pattern pattern = Pattern.compile("[a-z]+");
                Matcher matcher = pattern.matcher(s.toLowerCase());
                while (matcher.find()) {
                    data.add(matcher.group());
                }
            }
            Map<String,Integer> map=new HashMap<>();
            for(String i:data){
                //if(i<='z'&&i>='a'){
                    if(map.keySet().contains(i))
                    {
                        int x=map.get(i);
                        map.put(i,++x);
                    }
                    else {
                        map.put(i,1);    }
                //}
            }
            Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                    toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                            LinkedHashMap::new));
            for (String c:sortedMap.keySet())
            {
                System.out.println(c+"  "+sortedMap.get(c));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
