<template>
  <n-card>
    <v-chart autoresize :option="option" />
  </n-card>
</template>

<script setup lang="ts">
import VChart from 'vue-echarts'
import { EChartsOption } from 'echarts'

const option = ref<EChartsOption>({
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [820, 932, 901, 934, 1290, 1330, 1320],
      type: 'line',
      smooth: true
    }
  ]
})
</script>
