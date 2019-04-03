package chapter14;

import javax.script.*;

public class Task2 {

    private static final String ENGINE_NAME = "nashorn";
    private static final String JSON_VALUE = "'{\"result\":true, \"count\":42}'";
    private static final String JSON_RAW = "{\"result\":true, \"count\":42}";

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        testEval();

        testInvokeFunction();

        tetsInterface();
    }

    private static void testEval() throws ScriptException {
        ScriptEngine scriptEngine = getScriptEngine();

        Object jsObject = scriptEngine.eval("JSON.parse(" + JSON_VALUE + ")");

        Bindings scope = scriptEngine.createBindings();
        scope.put("jsObject", jsObject);

        Object result = scriptEngine.eval("JSON.stringify(jsObject)", scope);

        System.out.println(result);
    }

    private static void testInvokeFunction() throws ScriptException, NoSuchMethodException {
        ScriptEngine scriptEngine = getScriptEngine();
        Invocable invocable = (Invocable) scriptEngine;

        Object json = scriptEngine.eval("JSON");

        Object o = invocable.invokeMethod(json,"parse", JSON_RAW);

        Object result = invocable.invokeMethod(json, "stringify", o);

        System.out.println(result);
    }

    private static void tetsInterface() throws ScriptException {
        ScriptEngine scriptEngine = getScriptEngine();
        Invocable invocable = (Invocable) scriptEngine;

        Object jsonObj = scriptEngine.eval("JSON");

        JSON anInterface = invocable.getInterface(jsonObj ,JSON.class);

        Object obj = anInterface.parse(JSON_RAW);
        String jsonString = anInterface.stringify(obj);

        System.out.println(jsonString);

    }

    private static ScriptEngine getScriptEngine() {
        return new ScriptEngineManager().getEngineByName(ENGINE_NAME);
    }

    public interface JSON {
        Object parse(String json);
        String stringify(Object object);
    }

}
