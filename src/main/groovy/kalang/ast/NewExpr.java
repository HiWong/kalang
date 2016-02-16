/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class NewExpr extends ExprNode{
    
    public Type type;
    
    public List<ExprNode> arguments;
    
    
    public NewExpr(){
        
            if(arguments == null) arguments = new LinkedList();
        
    }
    
    
    public NewExpr(Type type,List<ExprNode> arguments){
        
            if(arguments == null) arguments = new LinkedList();
        
        
            this.type = type;
        
            this.arguments = arguments;
        
    }
    
    
    public static NewExpr create(){
        NewExpr node = new NewExpr();
        
        node.arguments = new LinkedList();
        
        return node;
    }
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,arguments);
        
        return ls;
    }
    
    public String toString(){
        String str = "NewExpr{\r\n";
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        if(arguments!=null){
            str += "  arguments:" + arguments.toString()+"\r\n";
        }
        
        return str+"}";
    }
}