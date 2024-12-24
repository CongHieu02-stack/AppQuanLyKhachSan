package UI;

import java.io.PrintWriter;

public class ThongBaoThemHoaDonCUI {
private PrintWriter SysOut = null;
public ThongBaoThemHoaDonCUI()
{

}
public ThongBaoThemHoaDonCUI(PrintWriter sysout)
{
    SysOut = sysout;
}
public void InThongBao(String nd)
{
SysOut.println(nd);
}
}
