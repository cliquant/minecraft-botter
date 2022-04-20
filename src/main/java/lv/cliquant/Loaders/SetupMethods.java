 package lv.cliquant.Loaders;
 import java.util.HashMap;

 import lv.cliquant.Methods.*;

 public class SetupMethods {
   public static final HashMap<String, SelMethod> methods = new HashMap<>();
   
   public void setup() {
     methods.put("join", new Join());
     methods.put("nullping", new NullPing());
     methods.put("motd", new Motd());
     methods.put("exploitbot", new CustomPayload());
     methods.put("exploitbot2", new CustomPayloadv2());
     methods.put("tcpshield", new TCPShield());
     methods.put("premiumkiller", new PremiumKiller());
   }
   
   public SelMethod setMethod(String methodName) {
    return (SelMethod)methods.getOrDefault(methodName, new Join());
   }
 }


// © 2022 Copyright www.pixeldown.ml - Cliquant
