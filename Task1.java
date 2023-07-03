import java.lang.reflect.Array;

/**
 * Task1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
 * используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} 
select * from students where 'name=Ivanov' and 'country=Russia' and...
 */
public class Task1 {

  public static void main(String[] args) {
    System.out.println("select * from students where " + task1("\"{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}\""));
  }

  static StringBuilder task1 (String str) {
    StringBuilder stringBuilder = new StringBuilder();
    String str1 = str.replace("{", "");
    String str2 = str1.replace("}", "");
    String str3 = str2.replace("\"", "");
    //String str4 = str3.replace(":", "=");
    String [] arr = str3.split(",");

    for (int i = 0; i < arr.length; i++) {
      String [] arr1 = arr[i].split(":");
      if (arr1[1].equals("null")== false) {

        stringBuilder.append ("'");
        stringBuilder.append (arr1[0]);
        stringBuilder.append ("=");
        stringBuilder.append (arr1[1]);
        stringBuilder.append ("'");
        stringBuilder.append (" and ");
        
          
        }
      }
      return stringBuilder; 
    }

    


  }