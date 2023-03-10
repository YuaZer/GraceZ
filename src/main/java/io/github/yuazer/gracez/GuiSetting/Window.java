package io.github.yuazer.gracez.GuiSetting;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Window {
    private int width, height;
    private String title;
    private static Window window = null;
    private long glfwWindow;

    public Window(int height, int width, String title) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    public static Window get() {
        if (Window.window == null) {
            Window window = new Window(Window.get().height, Window.get().width, Window.get().title);
        }
        return Window.window;
    }

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        glfwInit();//初始化GLFW
        init();
        loop();
    }

    public void init() {
        //Setup an error callback
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        //Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);//设置主版本号
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);//设置次版本号
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);//使用核心模式
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create the GLFW Window.");
        }
        //Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        //Enable the v-sync
        glfwSwapInterval(1);
        //Make the window visable
        glfwShowWindow(glfwWindow);
        GL.createCapabilities();
    }

    public void loop() {
        while (!glfwWindowShouldClose(glfwWindow)) {
            //Poll Events
            glfwPollEvents();
            glClearColor(0.0f, 0.2f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfwWindow);
        }
        glfwTerminate();
    }
}
