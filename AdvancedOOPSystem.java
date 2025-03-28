import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Advanced Java OOP and Design Patterns Demonstration
 * 
 * This comprehensive example showcases:
 * 1. Advanced Design Patterns
 * 2. Functional Programming Interfaces
 * 3. Generics and Bounded Type Parameters
 * 4. Reflection
 * 5. Custom Annotations
 * 6. Concurrent Programming
 * 7. Stream API
 * 8. Advanced Composition and Dependency Injection
 */
public class AdvancedOOPSystem {

    // 1. Custom Annotation for Method Logging and Validation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MethodMetrics {
        boolean logExecutionTime() default true;
        int maxExecutionTimeMs() default 1000;
    }

    // 2. Singleton Pattern with Lazy Initialization and Thread Safety
    public static class ConfigurationManager {
        private static volatile ConfigurationManager instance;
        private final Properties configProperties;

        private ConfigurationManager() {
            configProperties = new Properties();
            // Simulate loading configuration
            configProperties.setProperty("max.threads", "10");
            configProperties.setProperty("timeout.ms", "5000");
        }

        // Double-Checked Locking for Thread-Safe Singleton
        public static ConfigurationManager getInstance() {
            if (instance == null) {
                synchronized (ConfigurationManager.class) {
                    if (instance == null) {
                        instance = new ConfigurationManager();
                    }
                }
            }
            return instance;
        }

        public String getConfig(String key) {
            return configProperties.getProperty(key);
        }
    }

    // 3. Builder Pattern with Generics
    public static class GenericBuilder<T> {
        private final Supplier<T> instantiator;
        private final List<Consumer<T>> modifiers = new ArrayList<>();

        private GenericBuilder(Supplier<T> instantiator) {
            this.instantiator = instantiator;
        }

        public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
            return new GenericBuilder<>(instantiator);
        }

        public <V> GenericBuilder<T> with(BiConsumer<T, V> setter, V value) {
            modifiers.add(instance -> setter.accept(instance, value));
            return this;
        }

        public T build() {
            T value = instantiator.get();
            modifiers.forEach(modifier -> modifier.accept(value));
            return value;
        }
    }

    // 4. Advanced Factory Pattern with Functional Interfaces
    public interface DataProcessor<T, R> {
        R process(T input);
        
        // Default method in interface
        default R processWithLogging(T input) {
            long startTime = System.nanoTime();
            R result = process(input);
            System.out.printf("Processing time: %d ns%n", System.nanoTime() - startTime);
            return result;
        }
    }

    // 5. Dependency Injection and Strategy Pattern
    public static class DataProcessingPipeline<T, R> {
        private final List<DataProcessor<T, R>> processors;

        public DataProcessingPipeline(List<DataProcessor<T, R>> processors) {
            this.processors = processors;
        }

        public R executePipeline(T input) {
            R result = null;
            for (DataProcessor<T, R> processor : processors) {
                result = processor.process(input);
            }
            return result;
        }
    }

    // 6. Advanced Generics with Bounded Type Parameters
    public static class GenericRepository<T extends Comparable<T>> {
        private final List<T> items = new ArrayList<>();

        public void add(T item) {
            items.add(item);
        }

        public List<T> findItemsGreaterThan(T threshold) {
            return items.stream()
                .filter(item -> item.compareTo(threshold) > 0)
                .collect(Collectors.toList());
        }
    }

    // 7. Concurrent Processing with Executor Service
    public static class AsyncTaskProcessor {
        private final ExecutorService executorService;

        public AsyncTaskProcessor(int threadPoolSize) {
            executorService = Executors.newFixedThreadPool(threadPoolSize);
        }

        public <T, R> Future<R> submitTask(Callable<R> task) {
            return executorService.submit(task);
        }

        public void shutdown() {
            executorService.shutdown();
        }
    }

    // 8. Reflection-Based Method Invoker with Custom Annotation Processing
    public static class AnnotationProcessor {
        public static void processMethodMetrics(Object obj) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(MethodMetrics.class)) {
                    MethodMetrics metrics = method.getAnnotation(MethodMetrics.class);
                    
                    if (metrics.logExecutionTime()) {
                        long startTime = System.currentTimeMillis();
                        try {
                            method.setAccessible(true);
                            method.invoke(obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        long executionTime = System.currentTimeMillis() - startTime;
                        
                        if (executionTime > metrics.maxExecutionTimeMs()) {
                            System.out.printf("Method %s exceeded max execution time: %d ms%n", 
                                method.getName(), executionTime);
                        }
                    }
                }
            }
        }
    }

    // Example class to demonstrate annotations and metrics
    public static class DataAnalyzer {
        @MethodMetrics(logExecutionTime = true, maxExecutionTimeMs = 500)
        public void complexAnalysis() {
            // Simulate a complex analysis
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Demonstrate Singleton
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("Max Threads: " + config.getConfig("max.threads"));

        // Demonstrate Builder Pattern
        List<String> builtList = GenericBuilder.of(ArrayList::new)
            .with(List::add, "First")
            .with(List::add, "Second")
            .build();
        System.out.println("Built List: " + builtList);

        // Demonstrate Data Processing Pipeline
        DataProcessor<String, Integer> lengthProcessor = 
            input -> input.length();
        DataProcessor<Integer, String> conversionProcessor = 
            input -> "Length: " + input;
        
        DataProcessingPipeline<String, String> pipeline = 
            new DataProcessingPipeline<>(
                Arrays.asList(lengthProcessor, conversionProcessor)
            );
        
        System.out.println("Pipeline Result: " + 
            pipeline.executePipeline("Hello, Advanced OOP!"));

        // Demonstrate Generics Repository
        GenericRepository<Integer> intRepository = new GenericRepository<>();
        intRepository.add(10);
        intRepository.add(20);
        intRepository.add(5);
        
        System.out.println("Items > 7: " + 
            intRepository.findItemsGreaterThan(7));

        // Demonstrate Async Processing
        AsyncTaskProcessor asyncProcessor = 
            new AsyncTaskProcessor(
                Integer.parseInt(config.getConfig("max.threads"))
            );
        
        Future<Integer> futureResult = asyncProcessor.submitTask(() -> {
            Thread.sleep(100);
            return 42;
        });
        
        System.out.println("Async Result: " + futureResult.get());
        asyncProcessor.shutdown();

        // Demonstrate Annotation Processing
        DataAnalyzer analyzer = new DataAnalyzer();
        AnnotationProcessor.processMethodMetrics(analyzer);
    }
}