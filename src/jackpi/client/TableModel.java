package jackpi.client;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Levin
 */
public class TableModel extends AbstractTableModel
{
  public final String[] names = {"R1", "R2", "Ergebnis"};
  public final ArrayList<double[]> valueList = new ArrayList<>();


  public TableModel()
  {
    double[] tmp1 = {10.0, 50.0, 0.0}; 
    valueList.add(tmp1);
    double[] tmp2 = {20.0, 60.0, 0.0};
    valueList.add(tmp2);
  }
  
  

  @Override
  public int getRowCount()
  {
    return valueList.size();
  }

  @Override
  public int getColumnCount()
  {
    return names.length;
  }

  public double getDoubleAt(int rowIndex, int columnIndex)
  {
    return valueList.get(rowIndex)[columnIndex];
  }
  
  @Override
  public String getValueAt(int rowIndex, int columnIndex)
  {

    return String.format("%.2f", getDoubleAt(rowIndex, columnIndex));
  }

  public void setValueAt(double aValue, int rowIndex, int columnIndex)
  {
    double[] tmp = valueList.get(rowIndex);
    tmp[columnIndex] = aValue;
    
    valueList.set(rowIndex, tmp);
  }
  
  public void add(double r1, double r2)
  {
    double[] tmp = {r1, r2, 0.0};
    valueList.add(tmp);
  }

  @Override
  public String getColumnName(int column)
  {
    return names[column];
  }
    
    
    
    
    
    
    
    
    
    
}
