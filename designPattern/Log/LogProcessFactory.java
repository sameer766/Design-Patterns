package all_projects.src.designPattern.Log;//package com.whizdm.mockserver.Log;
//
//import java.util.Hashtable;
//
//public class LogProcessFactory {
//
//    LogProcessFactory nextLogProcessor;
//    LogProcessFactory(LogProcessFactory logProcessFactory){
//        this.nextLogProcessor = logProcessFactory;
//    }
//
//    public void log (LogLevel logLevel, String message){
//        if(nextLogProcessor != null)
//         nextLogProcessor.log(logLevel, message);
//    }
//}
//
//
//enum LogLevel{
//    INFO, ERROR, WARNING
//}
//
// class InfoLogProcess extends LogProcessFactory{
//
//    LogProcessFactory next;
//     InfoLogProcess(LogProcessFactory logProcessFactory) {
//         super(logProcessFactory);
//         this.next=logProcessFactory;
//     }
//
//     public void log (LogLevel logLevel, String message){
//         if(logLevel == LogLevel.INFO){
//             System.out.println("INFO : " + message);
//         } else {
//             next.log(logLevel, message);
//         }
//     }
// }
//
//class WarnLog extends LogProcessFactory{
//
//
//    WarnLog(LogProcessFactory logProcessFactory) {
//        super(logProcessFactory);
//    }
//
//    public void log (LogLevel logLevel, String message){
//        if(logLevel == LogLevel.WARNING){
//            System.out.println("WARNING : " + message);
//        } else {
//            super.log(logLevel, message);
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        InfoLogProcess infoLogProcess = new InfoLogProcess(new WarnLog(null));
//        infoLogProcess.log(LogLevel.ERROR, "bcehbcheb");
//    }
//}
//
//
//
//
//class  MapCustom<K,V>{
//
//
//
//    Entry[] hashtable;
//
//    public MapCustom(){
//
//        hashtable = new Entry[16];
//    }
//
//
//    public MapCustom(int size){
//       size =  getSizeFor(size);
//        hashtable =  new Entry[size];
//    }
//
//
//    public void put(K key, V vALUE) {
//        int hascode = key.hashCode() % hashtable.length;
//        Entry entry = hashtable[hascode];
//        if(entry == null){
//            hashtable[hascode] = new Entry(key, vALUE);
//        }else {
//
//            Entry prv = entry;
//            while (entry.next != null){
//                if(entry.key == key){
//                    entry.value = vALUE ;
//                    return;
//                }
//                prv = entry;
//                entry=entry.next;
//            }
//            prv.next = new Entry(key, vALUE);
//        }
//
//    }
//
//
//    public  V get(K k){
//        int i = k.hashCode() % hashtable.length;
//        Entry node = hashtable[i];
//
//        while (node != null){
//            if(node.key == k){
//                return node.value;
//            }
//            node=node.next;
//        }
//        return null;
//    }
//    class Entry{
//        K key;
//        V value;
//
//        Entry next;
//
//
//        public Entry(K k, V v) {
//            this.key = k;
//            this.value = v;
//        }
//    }
//
//    private int getSizeFor(int size) {
//        int n = size-1;
//        n |=n >>>  1;
//        n |=n >>>  2;
//        n |=n >>>  4;
//        n |=n >>>  8;
//        n |=n >>>  16;
//        return n< 0 ? 1 : n > (2^31-1) ?2^31-1 : n+1;
//
//    }
//
////    public MapCustom(){
////
////        hashtable = new Hashtable<>(16);
////    }
//}
