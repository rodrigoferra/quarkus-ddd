package com.dolap.quarkus.ddd.infrastructure.rest;

import com.dolap.quarkus.ddd.application.member.controller.MemberController;
import com.dolap.quarkus.ddd.application.member.manager.MemberManager;
import com.dolap.quarkus.ddd.application.member.message.request.CreateMemberRequest;
import com.dolap.quarkus.ddd.application.member.message.request.UpdateMemberRequest;
import com.dolap.quarkus.ddd.application.member.message.response.CreateMemberResponse;
import com.dolap.quarkus.ddd.application.member.message.response.DeleteMemberResponse;
import com.dolap.quarkus.ddd.application.member.message.response.GetMemberByIdResponse;
import com.dolap.quarkus.ddd.application.member.message.response.GetMembersResponse;
import com.dolap.quarkus.ddd.application.member.message.response.UpdateMemberResponse;
import com.dolap.quarkus.ddd.infrastructure.interceptor.Logged;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberRestController implements MemberController {

    private final MemberManager memberManager;

    public MemberRestController(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @GET
    @Logged
    @Override
    public GetMembersResponse getMembers() {
        return memberManager.getAllMembers();
    }

    @GET
    @Path("/{id}")
    @Logged
    @Override
    public GetMemberByIdResponse getMemberById(@PathParam(value = "id") Long id) {
        return memberManager.getMemberById(id);
    }

    @PUT
    @Logged
    @Override
    public UpdateMemberResponse update(UpdateMemberRequest updateMemberRequest) {
        return memberManager.updateMember(updateMemberRequest);
    }

    @POST
    @Logged
    @Override
    public CreateMemberResponse createMember(CreateMemberRequest createMemberRequest) {
        return memberManager.createMember(createMemberRequest);
    }

    @DELETE
    @Path("/{id}")
    @Logged
    @Override
    public DeleteMemberResponse deleteMemberById(@PathParam(value = "id") Long id) {
        return memberManager.deleteMember(id);
    }
}
