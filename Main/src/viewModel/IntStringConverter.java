package viewModel;

import javafx.util.StringConverter;

//TODO If this is going to be used -> move it to suitable package
public class IntStringConverter extends StringConverter<Number>
{
  @Override public String toString(Number number)
  {
    return number == null || number.intValue() == 0 ? "" : number.toString();
  }

  @Override public Number fromString(String s)
  {
    try
    {
      return Integer.parseInt(s);
    }
    catch (Exception e)
    {
      return 0;
    }
  }
}
