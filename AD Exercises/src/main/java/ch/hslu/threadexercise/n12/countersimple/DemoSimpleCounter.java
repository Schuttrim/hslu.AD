/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.threadexercise.n12.countersimple;

/**
 * Eine Demo für einen einfachen Zähler mit mehreren Threads.
 */
public class DemoSimpleCounter {

    public DemoSimpleCounter() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final SimpleCounter counter = new SimpleCounter();
        final SimpleCounterTask task1 = new SimpleCounterTask(counter);
        final SimpleCounterTask task2 = new SimpleCounterTask(counter);
        final SimpleCounterTask task3 = new SimpleCounterTask(counter);
        final Thread thread1 = new Thread(task1, "T1 : ");
        final Thread thread2 = new Thread(task2, "T2 : ");
        final Thread thread3 = new Thread(task3, "T3 : ");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
