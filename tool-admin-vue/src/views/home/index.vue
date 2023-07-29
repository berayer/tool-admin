<template>
  <n-grid class="text-center" :x-gap="8" :y-gap="12" cols="1 s:2 l:4" responsive="screen">
    <n-gi>
      <n-card>
        <n-statistic label="拆单数量" tabular-nums>
          <n-number-animation :from="0" :to="183" />
          单
        </n-statistic>
      </n-card>
    </n-gi>

    <n-gi>
      <n-card>
        <n-statistic label="报价数量">
          <n-number-animation :from="0" :to="183" />
          单
        </n-statistic>
      </n-card>
    </n-gi>

    <n-gi>
      <n-card>
        <n-statistic label="今日成交额">
          <n-number-animation :from="0" :to="36" />
          万
        </n-statistic>
      </n-card>
    </n-gi>

    <n-gi>
      <n-card>
        <n-statistic label="待处理">
          <n-number-animation :from="0" :to="916" />
          单
        </n-statistic>
      </n-card>
    </n-gi>
  </n-grid>

  <div class="my-4"></div>

    <n-grid cols="1 l:2" :x-gap="8" :y-gap="12" responsive="screen">
      <n-gi>
        <OrderStatus style="height: 300px" />
      </n-gi>

      <n-gi>
        <OrderTypeSale style="height: 300px" />
      </n-gi>

      <n-gi>
        <MonthSale style="height: 300px" />
      </n-gi>
    </n-grid>
</template>

<script setup lang="ts">
import { OrderTypeSale, OrderStatus, MonthSale } from './echarts'
</script>
