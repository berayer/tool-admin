<template>
  <div ref="box"></div>
</template>

<script setup lang="ts">
import * as THREE from 'three'
import { OrbitControls } from 'three/addons/controls/OrbitControls.js'
import { GUI } from 'three/addons/libs/lil-gui.module.min.js'

const box = ref<HTMLDivElement>()
const state = reactive({
  width: 800,
  height: 600
})

const cmOps = reactive({
  x: 3200,
  y: 4900,
  z: 3650
})

const gui = new GUI()

// 场景
const scene = new THREE.Scene()
const k = state.width / state.height

// 环境光
var ambient = new THREE.AmbientLight(0xffffff)
scene.add(ambient) //环境光对象添加到scene场景中

// 场景添加坐标系
const axesHelper = new THREE.AxesHelper(1500)
scene.add(axesHelper)

// 添加场景相机
const camera = new THREE.PerspectiveCamera(20, k, 1, 10000)
camera.position.set(cmOps.x, cmOps.y, cmOps.z)
camera.lookAt(scene.position)

const x = gui.add(camera.position, 'x', 100, 10000, 50)
const y = gui.add(camera.position, 'y', 100, 10000, 50)
const z = gui.add(camera.position, 'z', 100, 10000, 50)

// 渲染器配置
const renderer = new THREE.WebGLRenderer({
  antialias: true
})
renderer.setSize(state.width, state.height)
renderer.setClearColor(0xffffff, 1)

// 插件,用于鼠标控制距离
new OrbitControls(camera, renderer.domElement)

onMounted(() => {
  if (!box.value) {
    console.error('无法加载画布!')
    return
  }
  box.value!.style.height = `${state.height}px`
  box.value!.style.width = `${state.width}px`
  box.value.appendChild(renderer.domElement)

  gui.domElement.style.position = 'absolute'
  gui.domElement.style.right = '0'
  box.value!.style.position = 'relative'
  box.value.appendChild(gui.domElement)

  render()
})

// 页面渲染函数
function render() {
  renderer.render(scene, camera) //执行渲染操作

  x.setValue(camera.position.x)
  y.setValue(camera.position.y)
  z.setValue(camera.position.z)

  requestAnimationFrame(render) //请求再次执行渲染函数render
}
</script>
