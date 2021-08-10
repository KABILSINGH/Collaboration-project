package com.collaborationApp.dao;

import java.util.List;

import com.collaborationApp.model.Job;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public interface JobDao {
void addJob(Job job);
List<Job> getAllJobs();
Job getJob(int id);
}
