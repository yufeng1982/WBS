
import { axios } from '@/utils/request'

const baseURL = 'http://localhost:8888/api'

function getRequest (url, params) {
  return axios({
    url: baseURL + url,
    method: 'get',
    data: params
  })
}

function putRequest (url, params) {
  return axios({
    url: baseURL + url,
    method: 'put',
    data: params
  })
}

function postRequest (url, params) {
  return axios({
    url: baseURL + url,
    method: 'post',
    data: params
  })
}

function delRequest (url, params) {
  return axios({
    url: baseURL + url,
    method: 'delete',
    data: params
  })
}

export default {
	install: function (Vue) {
		Vue.prototype.getRequest = getRequest
    Vue.prototype.postRequest = postRequest
    Vue.prototype.putRequest = putRequest
    Vue.prototype.delRequest = delRequest
	},
  baseURL
}
