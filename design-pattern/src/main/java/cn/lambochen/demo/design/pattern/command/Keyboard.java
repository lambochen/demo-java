package cn.lambochen.demo.design.pattern.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lambochen
 * @date 2022-04-07 22:49
 *
 * 键盘控制器类
 */
public class Keyboard {

    public enum KeyCode {
        F1, F2, ESC, UP, DOWN, LEFT, RIGHT;
    }

    private Map<KeyCode, List<Command>> keyCommands = new HashMap<>();

    public void bindKeyCommand(KeyCode keyCode, List<Command> commands) {
        this.keyCommands.put(keyCode, commands);
    }

    public void onKeyPressed(KeyCode keyCode) {
        List<Command> commands = this.keyCommands.get(keyCode);

        if (null == commands) {
            return;
        }

        commands.forEach(Command::exe);
    }

}
