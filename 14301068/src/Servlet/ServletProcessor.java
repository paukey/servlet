package Servlet;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.io.File;
import java.io.IOException;
 
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Servlet.Request;
import Servlet.Response;
 
public class ServletProcessor {
 
 public void process(Request request, Response response,String servletName) {
 
 //������������ڴ�ָ��JAR�ļ���Ŀ¼������
 URLClassLoader loader = null;
 try {
 URLStreamHandler streamHandler = null;
 //�����������
 loader = new URLClassLoader(new URL[]{new URL(null, "file:" + 
 System.getProperty("user.dir")+ File.separator, 
 streamHandler)});
 } catch (IOException e) {
 System.out.println(e.toString());
 }
  
 Class<?> myClass = null;
 try {
 //���ض�Ӧ��servlet��
 myClass = loader.loadClass(servletName);
 } catch (ClassNotFoundException e) {
 System.out.println(e.toString());
 }
 
 Servlet servlet = null;
 
 try {
 //����servletʵ��
 servlet = (Servlet) myClass.newInstance();
 //ִ��ervlet��service����
 servlet.service((ServletRequest) request,(ServletResponse) response);
 } catch (Exception e) {
 System.out.println(e.toString());
 } catch (Throwable e) {
 System.out.println(e.toString());
 }
 
 }
 
}
