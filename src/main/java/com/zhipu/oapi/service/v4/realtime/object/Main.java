package com.zhipu.oapi.service.v4.realtime.object;

import java.io.FileWriter;
import java.io.IOException;


public class Main {
    private static final String[] CLASS_NAMES = {
            "ConversationCreated",
            "ConversationItemCreated",
            "ConversationItemDeleted",
            "ConversationItemInputAudioTranscriptionCompleted",
            "ConversationItemInputAudioTranscriptionFailed",
            "ConversationItemTruncated",
//            "RealtimeError",
            "InputAudioBufferCleared",
            "InputAudioBufferCommitted",
            "InputAudioBufferSpeechStarted",
            "InputAudioBufferSpeechStopped",
            "RateLimitsUpdated",
            "ResponseAudioDelta",
            "ResponseAudioDone",
            "ResponseAudioTranscriptDelta",
            "ResponseAudioTranscriptDone",
            "ResponseContentPartAdded",
            "ResponseContentPartDone",
            "ResponseCreated",
            "ResponseDone",
            "ResponseFunctionCallArgumentsDelta",
            "ResponseFunctionCallArgumentsDone",
            "ResponseOutputItemAdded",
            "ResponseOutputItemDone",
            "ResponseTextDelta",
            "ResponseTextDone",
//            "SessionCreated",
            "SessionUpdated"
    };

    public static void main(String[] args) {

        // 生成每个类的代码并写入文件
        for (String className : CLASS_NAMES) {
            String fileContent = generateClassFileContent(className);
            String filePath = "./src/main/java/com/zhipu/realtime/event/server/" + className + ".java";
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(fileContent);
                System.out.println("Generated: " + filePath);
            } catch (IOException e) {
                System.err.println("Error generating file: " + filePath);
                e.printStackTrace();
            }
        }
    }

    private static String generateClassFileContent(String className) {
        return String.format(
                "package com.zhipu.realtime.event.server;\n" +
                        "\n" +
                        "import com.zhipu.realtime.event.RealtimeServerEvent;\n" +
                        "\n" +
                        "public class %s extends RealtimeServerEvent {\n" +
                        "    // 类实现细节...\n" +
                        "}\n",
                className
        );
    }
}
