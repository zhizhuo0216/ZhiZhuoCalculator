package zhizhuo.a19960216.com.zhizhuocalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnJia,btnJian,btnCheng,btnChu
            ,btnDenYu,btnDian,btnDel,btnAnDel;
    public TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnAnDel=(Button)findViewById(R.id.btnC);
        btnDel=(Button)findViewById(R.id.btndel);
        btnDian=(Button)findViewById(R.id.btndian);
        btnDenYu=(Button)findViewById(R.id.btndenyu);
        btnJia=(Button)findViewById(R.id.btnjia);
        btnJian=(Button)findViewById(R.id.btnjian);
        btnCheng=(Button)findViewById(R.id.btncheng);
        btnChu=(Button)findViewById(R.id.btnchu);
        tvView=(TextView)findViewById(R.id.tvxiansi);
        CaoZhuo btnShuZi=new CaoZhuo();
        btn0.setOnClickListener(btnShuZi);
        btnDian.setOnClickListener(btnShuZi);
        btn1.setOnClickListener(btnShuZi);
        btn2.setOnClickListener(btnShuZi);
        btn3.setOnClickListener(btnShuZi);
        btn4.setOnClickListener(btnShuZi);
        btn5.setOnClickListener(btnShuZi);
        btn6.setOnClickListener(btnShuZi);
        btn7.setOnClickListener(btnShuZi);
        btn8.setOnClickListener(btnShuZi);
        btn9.setOnClickListener(btnShuZi);
        btnAnDel.setOnClickListener(btnShuZi);
        btnJia.setOnClickListener(btnShuZi);
        btnJian.setOnClickListener(btnShuZi);
        btnChu.setOnClickListener(btnShuZi);
        btnCheng.setOnClickListener(btnShuZi);
        btnDenYu.setOnClickListener(btnShuZi);
        btnDel.setOnClickListener(btnShuZi);
    }
    class CaoZhuo implements View.OnClickListener{
        private LinkedList<Object> list=new LinkedList();
        private LinkedList<Object> list1=new LinkedList();
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn0:
                    if(btn0Get()&&panDuan()<=6)
                        list.add(0);
                    break;
                case R.id.btn1:
                    if(panDuan()<=6)
                        list.add(1);
                    break;
                case R.id.btn2:
                    if(panDuan()<=6)
                        list.add(2);
                    break;
                case R.id.btn3:
                    if(panDuan()<=6)
                        list.add(3);
                    System.out.print("3");
                    break;
                case R.id.btn4:
                    if(panDuan()<=6)
                        list.add(4);
                    break;
                case R.id.btn5:
                    if(panDuan()<=6)
                        list.add(5);
                    break;
                case R.id.btn6:
                    if(panDuan()<=6)
                        list.add(6);
                    break;
                case R.id.btn7:
                    if(panDuan()<=6)
                        list.add(7);
                    break;
                case R.id.btn8:
                    if(panDuan()<=6)
                        list.add(8);
                    break;
                case R.id.btn9:
                    if(panDuan()<=6)
                        list.add(9);
                    break;
                case R.id.btnC:
                    list.clear();
                    break;
                case R.id.btnjia:
                    if(list.size()!=0) {
                        if (fuHao()) {
                            list.removeLast();
                            list.add("+");
                        } else
                            list.add("+");
                    }
                    break;
                case R.id.btnjian:
                    if(list.size()!=0) {
                        if(fuHao()){
                            list.removeLast();
                            list.add("-");
                        }
                        else
                            list.add("-");
                    }
                    break;

                case R.id.btncheng:
                    if(list.size()!=0) {
                        if(fuHao()){
                            list.removeLast();
                            list.add("*");
                        }
                        else
                            list.add("*");}
                    break;

                case R.id.btnchu:
                    if(list.size()!=0) {
                        if (fuHao()) {
                            list.removeLast();
                            list.add("/");
                        } else
                            list.add("/");
                    }
                    break;
                case R.id.btndian:
                    if(getDian()==false&&!list.getLast().toString().equals("+")||getDian()==false&&!list.getLast().toString().equals("-")||
                            getDian()==false&&!list.getLast().toString().equals("*")||getDian()==false&&!list.getLast().toString().equals("/"))
                        list.add(".");
                    break;
                case R.id.btndel:
                    if(getList()>0){
                        list.removeLast();
                    }
                    break;
            }
            xianShi();
            if(v.getId()==R.id.btndenyu){
                if(list.size()>0){
                    if(list.getLast().equals("+")||list.getLast().equals("/")||
                            list.getLast().equals("-")||list.getLast().equals("*")) {
                        list.removeLast();
                    }
                    DenYu();
                }
            }
        }
        //判断当前当前是否可以输入0
        public boolean btn0Get(){
            boolean anJian=false;
            Matcher matcher = null;
            if((int)list.size()!=0) {
                String regEx ="[1-9]";
                Pattern pattern = Pattern.compile(regEx);

                String aa=list.getLast().toString();
                matcher = pattern.matcher(aa);
            }
            if(getList()==0||matcher.matches()){
                anJian=true;
            }
            else if(list.getLast().equals("+")||list.getLast().equals("-")||list.getLast().equals("*")||list.getLast().equals("/")) {
                anJian=true;
            }
            else if(getDian()){
                anJian=true;
            }
            return anJian;
        }
        //获取list的长度
        private int getList(){
            int list_Size=(int)list.size();
            return list_Size;
        }
        //判断是否可以输入点
        private boolean getDian(){
            boolean get_Dian=true;
            String regEx ="[0-9]";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(list.getLast().toString());
            if(list.getLast().toString().equals(".")){
                get_Dian=true;
            }
            if(matcher.matches()){
                for(int i=list.size()-1;i>=0;i--){
                    if(list.get(i).equals("+")||list.get(i).equals("/")||list.get(i).equals("*")||list.get(i).equals("-")){
                        for (int j=i;j<list.size();j++){
                            if(list.get(j).equals(".")){
                                get_Dian=true;
                                break;
                            }
                        }
                    }
                    if(list.get(i).equals(".")) {
                        get_Dian = true;
                        break;
                    }
                    if(i==0){
                        get_Dian=false;
                    }
                }
            }
            return get_Dian;
        }
        //返回当前输入的最近的数的长度，截止到前面最近的操作符
        private int getListInt(){
            int geti=0;
            boolean get_Dian=true;
            String regEx ="[0-9]";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher((String)list.getLast());
            if(matcher.matches()){
                for(int i=list.size()-1;i>=0;i--){
                    if(list.get(i).equals("+")||list.get(i).equals("/")||list.get(i).equals("*")||list.get(i).equals("-")) {
                        geti = list.size() - 1 - i;
                    }
                }
            }
            if(list.getLast().equals(".")){
                for(int i=list.size()-1;i>=0;i--){
                    if(list.get(i).equals("+")||list.get(i).equals("/")||list.get(i).equals("*")||list.get(i).equals("-")) {
                        geti = list.size() - 2 - i;
                    }
                }
            }
            if(list.getLast().equals("+")||list.getLast().equals("-")||list.getLast().equals("*")||list.getLast().equals("/")) {
                geti=0;
            }
            return geti;
        }
        //判断是否前面一个字符是操作符
        private boolean fuHao(){
            boolean fu=false;
            if(list.size()==0){
                fu=false;
            }
            else {
                if (list.getLast().equals("+") || list.getLast().equals("-") || list.getLast().equals("*") || list.getLast().equals("/")) {
                    fu = true;
                }
            }
            return fu;
        }
        //显示在文本框
        public void xianShi(){
            Object ob="";
            for (Object a:list
                    ) {
                if(a.equals("*")) {
                    String d="×";
                    ob=ob+d;
                }
                else if (a.equals("/")) {
                    String d="÷";
                    ob=ob+d;
                }
                else {
                    ob = ob + a.toString();
                }
            }
            tvView.setText(ob.toString());
        }
        //判断当前输入的数有几位
        public int panDuan(){
            int panDuani=0;
            String regEx ="[0-9]";
            Matcher matcher=null;
            Pattern pattern = Pattern.compile(regEx);

            for(int i=list.size()-1;i>=0;i--){
                if(list.get(i).equals("+")||list.get(i).equals("-")
                        ||list.get(i).equals("/")||list.get(i).equals("*")){
                    break;
                }
                else{
                    if(pattern.matcher((String)list.get(i).toString()).matches()){
                        panDuani++;
                    }
                }
            }
            return panDuani;
        }
        //计算过程
        public void DenYu(){
            boolean aa=false,bb=false;
            int i=0,jzg=1;
            double j=0,jzf=0.1;
            int qo=list1.size();
            double x,y,z=0;
            boolean pad=false,one=true;
            String regEx ="[0-9]";
            Matcher matcher=null;
            Pattern pattern = Pattern.compile(regEx);
            for (Object a:list
                    ) {
                if(pattern.matcher(a.toString()).matches()&&aa==false){
                    i=i*jzg+(int)a;
                    if(one==true){
                        jzg=10;
                    }
                }else if(a.equals(".")){
                    aa=true;
                }
                else if(pattern.matcher(a.toString()).matches()&&aa==true){
                    j=j+jzf*(int)a;
                    bb=true;
                    jzf=jzf*0.1;
                }
                else if (a.equals("+")) {
                    aa = false;
                    if(bb==true){
                        j=i+j;
                        list1.add(j);
                    }
                    else {
                        list1.add(i);
                    }
                    list1.add("+");
                    bb=false;
                    i=0;
                    j=0;
                    jzf=0.1;
                    jzg=1;
                } else if (a.equals("-")) {
                    aa = false;
                    if(bb==true){
                        j=i+j;
                        list1.add(j);
                    }
                    else {
                        list1.add(i);
                    }
                    list1.add("-");
                    bb=false;
                    i=0;
                    j=0;
                    jzf=0.1;
                    jzg=1;
                } else if (a.equals("*")) {
                    aa = false;
                    if(bb==true){
                        j=i+j;
                        list1.add(j);
                    }
                    else {
                        list1.add(i);
                    }
                    list1.add("*");
                    bb=false;
                    i=0;
                    j=0;
                    jzf=0.1;
                    jzg=1;
                } else if (a.equals("/")) {
                    aa = false;
                    if(bb==true){
                        j=i+j;
                        list1.add(j);
                    }
                    else {
                        list1.add(i);
                    }
                    list1.add("/");
                    bb=false;
                    i=0;
                    j=0;
                    jzf=0.1;
                    jzg=1;
                }
            }
            if(bb==true){
                j=i+j;
                list1.add(j);
            }
            else {
                list1.add(i);
            }
            while(list1.size()>1) {
                i=-1;
                for(int jj=0;jj<list1.size();jj++){
                    i++;
                    if(pad==false) {
                        if (list1.get(jj).equals("*")) {
                            String ix=list1.get(i-1).toString();
                            String iy=list1.get(i+1).toString();
                            x=Double.valueOf(ix);
                            y=Double.valueOf(iy);
                            z = x * y;
                            list1.remove(i-1);
                            list1.remove(i);
                            list1.add(i,z);
                            list1.remove(i-1);
                            qo = list1.size();
                            j--;
                            i--;
                        }
                        else if (list1.get(jj).equals("/")) {
                            String ix=list1.get(i-1).toString();
                            String iy=list1.get(i+1).toString();
                            x=Double.valueOf(ix);
                            y=Double.valueOf(iy);
                            z = x / y;
                            list1.remove(i-1);
                            list1.remove(i);
                            list1.add(i,z);
                            list1.remove(i-1);
                            qo = list1.size();
                            j--;
                            i--;
                        }
                        qo = list1.size();
                        if (list1.size()==i+1){
                            pad = true;
                            break;
                        }
                    }
                    else {
                        if(list1.get(jj).equals("+"))
                        {
                            String ix=list1.get(i-1).toString();
                            String iy=list1.get(i+1).toString();
                            x=Double.valueOf(ix);
                            y=Double.valueOf(iy);
                            z=x+y;
                            list1.remove(i-1);
                            list1.remove(i);
                            list1.add(i,z);
                            list1.remove(i-1);
                            qo=list1.size();
                            j--;
                        }
                        else if(list1.get(jj).equals("-"))
                        {
                            String ix=list1.get(i-1).toString();
                            String iy=list1.get(i+1).toString();
                            x=Double.valueOf(ix);
                            y=Double.valueOf(iy);
                            z=x-y;
                            list1.remove(i-1);
                            list1.remove(i);
                            list1.add(i,z);
                            list1.remove(i-1);
                            qo=list1.size();
                            j--;
                        }
                    }
                }
            }
            String strjieg=list1.get(0).toString();
            double add= Double.valueOf(strjieg);
            if(add==(int)add) {
                tvView.setText((int)add+"");
            }
            else{
                tvView.setText(add+"");
            }
            list1.clear();
            list.clear();
        }
    }
}

