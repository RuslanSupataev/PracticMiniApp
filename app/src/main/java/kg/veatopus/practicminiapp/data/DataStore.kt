package kg.veatopus.practicminiapp.data

import kg.veatopus.practicminiapp.domain.model.Task

object DataStore {
	
	private val tasks = mutableListOf<Task>()
	
	fun add(task: Task) {
		tasks.add(task)
	}
	
	fun getAll() = tasks.toList()
}