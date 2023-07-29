<template>
  <n-card>
    <v-chart autoresize :option="option" />
  </n-card>
</template>

<script setup lang="ts">
import VChart from 'vue-echarts'
import { EChartsOption } from 'echarts'

const option = ref<EChartsOption>({
  legend: {
    left: 'center'
  },
  tooltip: {
    valueFormatter: (value) => `${value} (万元)`
  },
  series: [
    {
      name: '销售额',
      type: 'pie',
      radius: ['40%', '70%'],
      top: '5%',
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        formatter: '{d}%'
      },
      // emphasis: {
      //   label: {
      //     show: true,
      //     fontSize: 20,
      //     fontWeight: 'bold'
      //   }
      // },
      labelLine: {
        show: true
      },
      data: [
        { value: 1046, name: '常规单' },
        { value: 735.6, name: '活动家具' },
        { value: 580.4, name: '板式配套' },
        { value: 484.7, name: '饰品单' },
        { value: 300, name: '物料单' }
      ]
    }
  ]
})
</script>
