import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

class AddStudent implements ActionListener{
    
            ArrayList<Student> students = new ArrayList<>();
            
    public void actionPerformed(ActionEvent e){
        
    JDialog dialog=new JDialog();
    JButton w=new JButton("Add student");
    
    dialog.setLayout(null);
    dialog.setSize(350,470);
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(null);
    
    JComboBox dd,nn,ff,ii,oo,pp;
    JTextField aa,bb,cc,kk,ll,gg,hh,jj; 
    JLabel a,b,c,d,n,f,k,l,g,h,j,i,o,p;
    
    a=new JLabel("First name");
    a.setFont(new Font("", Font.BOLD, 15));
    a.setBounds(20,15,150,40);
    dialog.add(a);
    
    aa=new JTextField();
    aa.setFont(new Font("", Font.BOLD, 16));
    aa.setBounds(130,20,150,30);
    dialog.add(aa);
    
    b=new JLabel("Last name");
    b.setFont(new Font("", Font.BOLD, 15));
    b.setBounds(20,45,150,40);
    dialog.add(b);
    
    bb=new JTextField();
    bb.setFont(new Font("", Font.BOLD, 16));
    bb.setBounds(130,50,150,30);
    dialog.add(bb);
    
    c=new JLabel("Position");
    c.setFont(new Font("", Font.BOLD, 15));
    c.setBounds(20,75,150,40);
    dialog.add(c);
    
    cc=new JTextField();
    cc.setFont(new Font("", Font.BOLD, 16));
    cc.setBounds(130,80,150,30);
    dialog.add(cc);
    
    d=new JLabel("Date of birth :D");
    d.setFont(new Font("", Font.BOLD, 15));
    d.setBounds(20,105,150,40);
    dialog.add(d);
    
    String[] q={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    
    dd=new JComboBox(q);
    dd.setFont(new Font("", Font.BOLD, 16));
    dd.getSelectedItem();
    dd.setBounds(130,110,45,30);
    dialog.add(dd);
    
    n=new JLabel("M");
    n.setFont(new Font("", Font.BOLD, 15));
    n.setBounds(180,105,150,40);
    dialog.add(n);
    
    String[] qq={"1","2","3","4","5","6","7","8","9","10","11","12"};
    
    nn=new JComboBox(qq);
    nn.setFont(new Font("", Font.BOLD, 16));
    nn.setBounds(195,110,45,30);
    dialog.add(nn);
    
    f=new JLabel("Y");
    f.setFont(new Font("", Font.BOLD, 15));
    f.setBounds(245,105,150,40);
    dialog.add(f);
    
    String[] qqq={"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
   
    ff=new JComboBox(qqq);
    ff.setFont(new Font("", Font.BOLD, 16));
    ff.setBounds(260,110,70,30);
    dialog.add(ff);
    
    k=new JLabel("Effectiveness");
    k.setFont(new Font("", Font.BOLD, 15));
    k.setBounds(20,135,150,40);
    dialog.add(k);
    
    kk=new JTextField();
    kk.setFont(new Font("", Font.BOLD, 16));
    kk.setBounds(130,140,50,30);
    dialog.add(kk);
    
    l=new JLabel("ID");
    l.setFont(new Font("", Font.BOLD, 15));
    l.setBounds(20,165,150,40);
    dialog.add(l);
    
    ll=new JTextField();
    ll.setFont(new Font("", Font.BOLD, 16));
    ll.setBounds(130,170,150,30);
    dialog.add(ll);
    
    g=new JLabel("Group");
    g.setFont(new Font("",Font.BOLD,16));
    g.setBounds(20,195,150,40);
    dialog.add(g);
    
    gg=new JTextField();
    gg.setFont(new Font("", Font.BOLD, 16));
    gg.setBounds(130,200,150,30);
    dialog.add(gg);
    
    h=new JLabel("Course name");
    h.setFont(new Font("",Font.BOLD,16));
    h.setBounds(20,225,150,40);
    dialog.add(h);
    
    hh=new JTextField();
    hh.setFont(new Font("", Font.BOLD, 16));
    hh.setBounds(130,230,150,30);
    dialog.add(hh);
    
    j=new JLabel("Course");
    j.setFont(new Font("",Font.BOLD,16));
    j.setBounds(20,255,150,40);
    dialog.add(j);
    
    jj=new JTextField();
    jj.setFont(new Font("", Font.BOLD, 16));
    jj.setBounds(130,260,50,30);
    dialog.add(jj);
    
    i=new JLabel("Course started :D");
    i.setFont(new Font("", Font.BOLD, 15));
    i.setBounds(5,285,150,40);
    dialog.add(i);
    
    ii=new JComboBox(q);
    ii.setFont(new Font("", Font.BOLD, 16));
    ii.getSelectedItem();
    ii.setBounds(130,290,45,30);
    dialog.add(ii);
    
    o=new JLabel("M");
    o.setFont(new Font("", Font.BOLD, 15));
    o.setBounds(180,285,150,40);
    dialog.add(o);
    
    oo=new JComboBox(qq);
    oo.setFont(new Font("", Font.BOLD, 16));
    oo.setBounds(195,290,45,30);
    dialog.add(oo);
    
    p=new JLabel("Y");
    p.setFont(new Font("", Font.BOLD, 15));
    p.setBounds(245,285,150,40);
    dialog.add(p);
    
    String[] qqqq={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
    
    pp=new JComboBox(qqqq);
    pp.setFont(new Font("", Font.BOLD, 16));
    pp.setBounds(260,290,70,30);
    dialog.add(pp);
    
    w.setFont(new Font("",Font.BOLD,16));
    w.setBounds(40,380, 250, 50);
    dialog.add(w);
    
    w.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            String aaa,bbb,ccc,lll,ggg,hhh;
            int ddd,nnn,fff,kkk,jjj,iii,ooo,ppp;
            
            aaa=aa.getText();//First name
            bbb=bb.getText();//Last name
            ccc=cc.getText();//Position
            ddd=dd.getSelectedIndex();//Birth day
            nnn=nn.getSelectedIndex();//Birth month
            fff=ff.getSelectedIndex();//Birth year
            kkk=Integer.parseInt(kk.getText());//Effectiveness
            lll=ll.getText();//Id
            ggg=gg.getText();//Group
            hhh=hh.getText();//Course name
            jjj=Integer.parseInt(jj.getText());//Course
            iii=ii.getSelectedIndex();//Course start day
            ooo=oo.getSelectedIndex();//Course start month
            ppp=pp.getSelectedIndex();//Course start year
            
            Student s=new Student();
            
            s.setFirstName(aaa);
            s.setLastName(bbb);
            s.setPosition(ccc);
            s.setBirthDay(ddd);
            s.setBirthMonth(nnn);
            s.setBirthYear(fff);
            s.setEffectiveness(kkk);
            s.setId(lll);
            s.setGroup(ggg);
            s.setCourseName(hhh);
            s.setCourse(jjj);
            s.setDay(iii);
            s.setCourseStartMonth(ooo);
            s.setCourseStartYear(ppp);
            
            students.add(s);
            
            dialog.dispose();
        }
    
        });
    }
}