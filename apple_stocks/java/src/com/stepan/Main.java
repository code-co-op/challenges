package com.stepan;

import java.util.Random;

public class Main {

    // Brute force max profit: 999829
    // Fork join max profit:   999829
    // Brute force time: 44138273
    // Fork join time:   2036238
    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        int maxProfitBruteForceTest = getMaxProfitBruteForce(stockPricesYesterday);
        assertEquals(6, maxProfitBruteForceTest);
        int maxProfitForkJoinTest = getMaxProfitForkJoin(stockPricesYesterday);
        assertEquals(6, maxProfitForkJoinTest);

        int[] randomStockPrices = generateRandomStockPrices(10_000);

        long bruteForceStartTime = System.nanoTime();
        int maxProfitBruteForce = getMaxProfitBruteForce(randomStockPrices);
        long bruteForceEndTime = System.nanoTime();

        long forkJoinStartTime = System.nanoTime();
        int maxProfitForkJoin = getMaxProfitForkJoin(randomStockPrices);
        long forkJoinEndTime = System.nanoTime();

        assertEquals(maxProfitBruteForce, maxProfitForkJoin);

        System.out.println(String.format("Brute force max profit: %d", maxProfitBruteForce));
        System.out.println(String.format("Fork join max profit:   %d", maxProfitForkJoin));
        System.out.println(String.format("Brute force time: %d", bruteForceEndTime - bruteForceStartTime));
        System.out.println(String.format("Fork join time:   %d", forkJoinEndTime - forkJoinStartTime));
    }

    private static int[] generateRandomStockPrices(int numberOfItems) {
        int[] stockPrices = new int[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            stockPrices[i] = new Random().nextInt(1000000);
        }

        return stockPrices;
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException(String.format("Value %d doesn't equal %d", expected, actual));
        }
    }

    private static int getMaxProfitBruteForce(int[] stockPricesYesterday) {
        int maxValue = 0;
        for (int i = stockPricesYesterday.length - 1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (stockPricesYesterday[i] - stockPricesYesterday[j] > maxValue) {
                    maxValue = stockPricesYesterday[i] - stockPricesYesterday[j];
                }
            }
        }

        return maxValue;
    }

    private static int getMaxProfitForkJoin(int[] stockPricesYesterday) {
        StockData stockData = getStockData(stockPricesYesterday, 0, stockPricesYesterday.length - 1);

        return stockData.getMaxProfit();
    }

    private static StockData getStockData(int[] stockPricesYesterday,
                                   int firstIndex,
                                   int lastIndex) {
        if (firstIndex == lastIndex) {
            return new StockData(stockPricesYesterday[firstIndex], stockPricesYesterday[firstIndex], 0);
        }
        if (lastIndex - firstIndex == 1) {
            return new StockData(
                    Math.min(stockPricesYesterday[firstIndex], stockPricesYesterday[lastIndex]),
                    Math.max(stockPricesYesterday[firstIndex], stockPricesYesterday[lastIndex]),
                    stockPricesYesterday[lastIndex] - stockPricesYesterday[firstIndex]);
        }
        int halfArray = getHalfIndex(firstIndex, lastIndex);
        StockData minStockData = getStockData(stockPricesYesterday, firstIndex, halfArray);
        StockData maxStockData = getStockData(stockPricesYesterday, halfArray + 1, lastIndex);
        return new StockData(
                Math.min(minStockData.getMinStockPrice(), maxStockData.getMinStockPrice()),
                Math.max(minStockData.getMaxStockPrice(), maxStockData.getMaxStockPrice()),
                Math.max(
                        Math.max(minStockData.getMaxProfit(), maxStockData.getMaxProfit()),
                        maxStockData.getMaxStockPrice() - minStockData.getMinStockPrice()));
    }

    private static int getHalfIndex(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) % 2 == 1) {
            return firstIndex + (lastIndex - firstIndex) / 2 + 1;
        } else {
            return firstIndex + (lastIndex - firstIndex) / 2;
        }
    }

    private static class StockData {

        private int minStockPrice;
        private int maxStockPrice;
        private int maxProfit;

        public StockData(int minStockPrice, int maxStockPrice, int maxProfit) {
            this.minStockPrice = minStockPrice;
            this.maxStockPrice = maxStockPrice;
            this.maxProfit = maxProfit;
        }

        public int getMinStockPrice() {
            return minStockPrice;
        }

        public int getMaxStockPrice() {
            return maxStockPrice;
        }

        public int getMaxProfit() {
            return maxProfit;
        }
    }
}
